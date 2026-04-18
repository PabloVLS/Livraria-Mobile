package com.example.livrariamobile

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.livrariamobile.viewmodel.BookViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var bookViewModel: BookViewModel
    private lateinit var bookAdapter: BookAdapter
    private lateinit var booksRecyclerView: RecyclerView
    private lateinit var loadingStateContainer: ConstraintLayout
    private lateinit var emptyStateContainer: ConstraintLayout
    private lateinit var errorStateContainer: ConstraintLayout
    private lateinit var searchTitleEditText: EditText
    private lateinit var searchAuthorEditText: EditText
    private lateinit var searchButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Initialize views
        booksRecyclerView = findViewById(R.id.booksRecyclerView)
        loadingStateContainer = findViewById(R.id.loadingStateContainer)
        emptyStateContainer = findViewById(R.id.emptyStateContainer)
        errorStateContainer = findViewById(R.id.errorStateContainer)
        searchTitleEditText = findViewById(R.id.searchTitleEditText)
        searchAuthorEditText = findViewById(R.id.searchAuthorEditText)
        searchButton = findViewById(R.id.searchButton)

        val main = findViewById<ConstraintLayout>(R.id.main)
        ViewCompat.setOnApplyWindowInsetsListener(main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Initialize ViewModel
        bookViewModel = ViewModelProvider(this).get(BookViewModel::class.java)

        setupRecyclerView()
        setupSearchListeners()
        observeViewModel()
    }

    private fun setupRecyclerView() {
        bookAdapter = BookAdapter()
        booksRecyclerView.apply {
            adapter = bookAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }

    private fun setupSearchListeners() {
        searchButton.setOnClickListener {
            performSearch()
        }

        searchTitleEditText.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == android.view.inputmethod.EditorInfo.IME_ACTION_SEARCH) {
                performSearch()
                true
            } else {
                false
            }
        }

        searchAuthorEditText.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == android.view.inputmethod.EditorInfo.IME_ACTION_SEARCH) {
                performSearch()
                true
            } else {
                false
            }
        }

        val retryButton = findViewById<Button>(R.id.retryButton)
        retryButton.setOnClickListener {
            val hasTitle = searchTitleEditText.text?.toString()?.isNotEmpty() == true
            val hasAuthor = searchAuthorEditText.text?.toString()?.isNotEmpty() == true
            if (hasTitle || hasAuthor) {
                performSearch()
            } else {
                showBooksList(emptyList())
            }
        }
    }

    private fun observeViewModel() {
        bookViewModel.isLoading.observe(this) { isLoading ->
            Log.d("MainActivity", "🔄 Loading: $isLoading")
            if (isLoading) {
                Log.d("MainActivity", "Showing loading state")
                showLoadingState()
            }
        }

        bookViewModel.books.observe(this) { books ->
            Log.d("MainActivity", "📚 Books received: ${books.size} items")
            books.forEach { book ->
                Log.d("MainActivity", "  - ${book.title} by ${book.author}")
            }
            if (books.isNotEmpty()) {
                Log.d("MainActivity", "✅ Showing book list")
                showBooksList(books)
                bookViewModel.clearError()
            } else {
                Log.d("MainActivity", "❌ No books, showing empty state")
                showEmptyState()
            }
        }

        bookViewModel.errorMessage.observe(this) { errorMessage ->
            Log.d("MainActivity", "⚠️ Error message: $errorMessage")
            if (!errorMessage.isNullOrEmpty()) {
                if (booksRecyclerView.visibility != View.VISIBLE) {
                    Log.d("MainActivity", "Showing error toast and error state")
                    Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()
                    showErrorState()
                }
            }
        }
    }

    private fun performSearch() {
        val title = searchTitleEditText.text?.toString()?.trim() ?: ""
        val author = searchAuthorEditText.text?.toString()?.trim() ?: ""

        Log.d("MainActivity", "Searching for - Title: $title, Author: $author")

        if (title.isEmpty() && author.isEmpty()) {
            showEmptyState()
            return
        }

        // Construir query combinada
        var query = ""
        if (title.isNotEmpty()) {
            query += "intitle:$title"
        }
        if (author.isNotEmpty()) {
            if (query.isNotEmpty()) query += " "
            query += "inauthor:$author"
        }

        bookViewModel.searchBooks(query)
    }

    private fun showBooksList(books: List<Book>) {
        Log.d("MainActivity", "🎯 showBooksList called with ${books.size} books")
        booksRecyclerView.visibility = View.VISIBLE
        loadingStateContainer.visibility = View.GONE
        emptyStateContainer.visibility = View.GONE
        errorStateContainer.visibility = View.GONE
        Log.d("MainActivity", "Updated visibility - RecyclerView is VISIBLE")

        bookAdapter.updateBooks(books)
        Log.d("MainActivity", "Updated adapter with ${books.size} books")

        Toast.makeText(this, "Encontrados ${books.size} livros!", Toast.LENGTH_SHORT).show()
    }

    private fun showLoadingState() {
        Log.d("MainActivity", "🔄 showLoadingState called")
        booksRecyclerView.visibility = View.GONE
        loadingStateContainer.visibility = View.VISIBLE
        emptyStateContainer.visibility = View.GONE
        errorStateContainer.visibility = View.GONE
    }

    private fun showEmptyState() {
        Log.d("MainActivity", "📭 showEmptyState called")
        booksRecyclerView.visibility = View.GONE
        loadingStateContainer.visibility = View.GONE
        emptyStateContainer.visibility = View.VISIBLE
        errorStateContainer.visibility = View.GONE
        Toast.makeText(this, "Nenhum livro encontrado", Toast.LENGTH_SHORT).show()
    }

    private fun showErrorState() {
        Log.d("MainActivity", "❌ showErrorState called")
        booksRecyclerView.visibility = View.GONE
        loadingStateContainer.visibility = View.GONE
        emptyStateContainer.visibility = View.GONE
        errorStateContainer.visibility = View.VISIBLE
    }
}