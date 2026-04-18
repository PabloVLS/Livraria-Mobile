package com.example.livrariamobile

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var bookAdapter: BookAdapter
    private lateinit var booksRecyclerView: RecyclerView
    private lateinit var loadingProgressBar: ProgressBar
    private lateinit var emptyStateContainer: ConstraintLayout
    private lateinit var errorStateContainer: ConstraintLayout
    private lateinit var searchEditText: EditText
    private lateinit var searchButton: Button

    // Mock data for demonstration
    private val mockBooks = listOf(
        Book(
            id = "1",
            title = "O Planeta dos Macacos",
            author = "Pierre Boulle",
            description = "Um clássico de ficção científica que explora temas sobre evolução e sociedade.",
            coverImageUrl = null
        ),
        Book(
            id = "2",
            title = "1984",
            author = "George Orwell",
            description = "Uma distopia futurista que retrata um totalitarismo extremo e a luta pela liberdade.",
            coverImageUrl = null
        ),
        Book(
            id = "3",
            title = "Dom Casmurro",
            author = "Machado de Assis",
            description = "Um romance brasileiro que explora ciúmes, traição e memória através de uma narrativa envolvente.",
            coverImageUrl = null
        ),
        Book(
            id = "4",
            title = "O Cortiço",
            author = "Aluísio Azevedo",
            description = "Uma obra que retrata a vida em um cortiço do Rio de Janeiro com realismo intenso.",
            coverImageUrl = null
        ),
        Book(
            id = "5",
            title = "O Senhor dos Anéis",
            author = "J.R.R. Tolkien",
            description = "Uma epopeia de fantasia que acompanha uma jornada pela Terra Média em busca de destruir um anel.",
            coverImageUrl = null
        ),
        Book(
            id = "6",
            title = "Cem Anos de Solidão",
            author = "Gabriel García Márquez",
            description = "Uma saga familiar que mistura realismo mágico com histórias de amor e morte.",
            coverImageUrl = null
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Initialize views using findViewById
        booksRecyclerView = findViewById(R.id.booksRecyclerView)
        loadingProgressBar = findViewById(R.id.loadingProgressBar)
        emptyStateContainer = findViewById(R.id.emptyStateContainer)
        errorStateContainer = findViewById(R.id.errorStateContainer)
        searchEditText = findViewById(R.id.searchEditText)
        searchButton = findViewById(R.id.searchButton)

        val main = findViewById<ConstraintLayout>(R.id.main)
        ViewCompat.setOnApplyWindowInsetsListener(main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setupRecyclerView()
        setupSearchListeners()
        showBooksList()
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

        searchEditText.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == android.view.inputmethod.EditorInfo.IME_ACTION_SEARCH) {
                performSearch()
                true
            } else {
                false
            }
        }

        val retryButton = findViewById<Button>(R.id.retryButton)
        retryButton.setOnClickListener {
            if (searchEditText.text?.toString()?.isNotEmpty() == true) {
                performSearch()
            } else {
                showBooksList()
            }
        }
    }

    private fun performSearch() {
        val query = searchEditText.text?.toString()?.trim() ?: ""

        if (query.isEmpty()) {
            showEmptyState()
            return
        }

        showLoadingState()

        // Simulate network delay
        findViewById<View>(R.id.main).postDelayed({
            val results = searchBooks(query)
            if (results.isEmpty()) {
                showEmptyState()
            } else {
                showBooksList(results)
            }
        }, 1500) // 1.5 second delay to simulate network request
    }

    private fun searchBooks(query: String): List<Book> {
        // Simple search implementation - filters by title or author
        val lowerQuery = query.lowercase()
        return mockBooks.filter { book ->
            book.title.lowercase().contains(lowerQuery) ||
            book.author.lowercase().contains(lowerQuery)
        }
    }

    private fun showBooksList(books: List<Book> = mockBooks) {
        booksRecyclerView.visibility = View.VISIBLE
        loadingProgressBar.visibility = View.GONE
        emptyStateContainer.visibility = View.GONE
        errorStateContainer.visibility = View.GONE
        bookAdapter.updateBooks(books)
    }

    private fun showLoadingState() {
        booksRecyclerView.visibility = View.GONE
        loadingProgressBar.visibility = View.VISIBLE
        emptyStateContainer.visibility = View.GONE
        errorStateContainer.visibility = View.GONE
    }

    private fun showEmptyState() {
        booksRecyclerView.visibility = View.GONE
        loadingProgressBar.visibility = View.GONE
        emptyStateContainer.visibility = View.VISIBLE
        errorStateContainer.visibility = View.GONE
    }

    private fun showErrorState() {
        booksRecyclerView.visibility = View.GONE
        loadingProgressBar.visibility = View.GONE
        emptyStateContainer.visibility = View.GONE
        errorStateContainer.visibility = View.VISIBLE
    }
}