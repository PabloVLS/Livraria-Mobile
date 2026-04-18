package com.example.livrariamobile

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

class BookAdapter(private var books: List<Book> = emptyList()) :
    RecyclerView.Adapter<BookAdapter.BookViewHolder>() {

    fun updateBooks(newBooks: List<Book>) {
        books = newBooks
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_book, parent, false)
        return BookViewHolder(view)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val book = books[position]
        holder.bind(book)
    }

    override fun getItemCount(): Int = books.size

    class BookViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        private val bookTitle: TextView = itemView.findViewById(R.id.bookTitle)
        private val bookAuthor: TextView = itemView.findViewById(R.id.bookAuthor)
        private val bookDescription: TextView = itemView.findViewById(R.id.bookDescription)
        private val bookCover: ImageView = itemView.findViewById(R.id.bookCover)

        fun bind(book: Book) {
            bookTitle.text = book.title
            bookAuthor.text = book.author
            bookDescription.text = book.description

            if (!book.coverImageUrl.isNullOrEmpty()) {
                var imageUrl = book.coverImageUrl
                if (imageUrl.startsWith("http://")) {
                    imageUrl = imageUrl.replace("http://", "https://")
                }

                Glide.with(itemView.context)
                    .load(imageUrl)
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .placeholder(R.color.surface)
                    .error(R.color.surface)
                    .centerCrop()
                    .into(bookCover)
            } else {
                bookCover.setBackgroundColor(
                    itemView.context.getColor(R.color.surface)
                )
            }

            // Click listener para abrir detalhes
            itemView.setOnClickListener {
                val intent = Intent(itemView.context, BookDetailActivity::class.java)
                intent.putExtra("book", book)
                itemView.context.startActivity(intent)
            }
        }
    }
}



