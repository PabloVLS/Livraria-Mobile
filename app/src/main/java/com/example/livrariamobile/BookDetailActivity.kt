package com.example.livrariamobile

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.google.android.material.button.MaterialButton

class BookDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_book_detail)

        val book = intent.getParcelableExtra<Book>("book") ?: Book("", "", "", "", null)

        val backButton = findViewById<MaterialButton>(R.id.backButton)
        backButton.setOnClickListener { finish() }

        val bookTitle = findViewById<TextView>(R.id.bookDetailTitle)
        val bookAuthor = findViewById<TextView>(R.id.bookDetailAuthor)
        val bookDescription = findViewById<TextView>(R.id.bookDetailDescription)
        val bookCover = findViewById<ImageView>(R.id.bookDetailCover)

        bookTitle.text = book.title
        bookAuthor.text = book.author
        bookDescription.text = book.description.ifEmpty { "Sem descrição" }

        if (!book.coverImageUrl.isNullOrEmpty()) {
            val url = book.coverImageUrl.replace("http://", "https://")
            Glide.with(this).load(url).transition(DrawableTransitionOptions.withCrossFade())
                .placeholder(R.color.surface).error(R.color.surface).into(bookCover)
        } else {
            bookCover.setBackgroundColor(getColor(R.color.surface))
        }

        val main = findViewById<ConstraintLayout>(R.id.main)
        ViewCompat.setOnApplyWindowInsetsListener(main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}

