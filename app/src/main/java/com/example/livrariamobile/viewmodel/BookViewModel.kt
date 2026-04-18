package com.example.livrariamobile.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.livrariamobile.Book
import com.example.livrariamobile.repository.BookRepository
import kotlinx.coroutines.launch

class BookViewModel : ViewModel() {
    private val _books = MutableLiveData<List<Book>>()
    val books: LiveData<List<Book>> = _books

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _errorMessage = MutableLiveData<String?>()
    val errorMessage: LiveData<String?> = _errorMessage

    fun searchBooks(query: String) {
        Log.d("BookViewModel", "searchBooks called with query: $query")

        if (query.isBlank()) {
            Log.d("BookViewModel", "Query is empty, setting empty list")
            _books.value = emptyList()
            _errorMessage.value = "Digite um termo de busca"
            return
        }

        _isLoading.value = true
        _errorMessage.value = null
        Log.d("BookViewModel", "Loading state set to true")

        viewModelScope.launch {
            try {
                Log.d("BookViewModel", "Starting API call for query: $query")
                val response = BookRepository.searchBooks(query)
                Log.d(
                    "BookViewModel",
                    "API response received: ${response.items?.size ?: 0} items (total=${response.totalItems ?: 0})"
                )

                val bookList = response.items
                    ?.mapNotNull { item ->
                        val info = item.volumeInfo ?: return@mapNotNull null
                        Book(
                            id = item.id.orEmpty(),
                            title = info.title ?: "Sem titulo",
                            author = info.authors?.joinToString(", ").orEmpty().ifBlank { "Desconhecido" },
                            description = info.description ?: "Sem descricao",
                            coverImageUrl = info.imageLinks?.thumbnail
                        )
                    }
                    ?: emptyList()

                Log.d("BookViewModel", "Mapped bookList size: ${bookList.size}")

                _books.value = bookList
                _errorMessage.value = null
            } catch (e: Exception) {
                Log.e("BookViewModel", "Exception caught: ${e.message}", e)
                _books.value = emptyList()
                _errorMessage.value = "Erro ao buscar: ${e.message}"
            } finally {
                Log.d("BookViewModel", "Setting loading state to false")
                _isLoading.value = false
            }
        }
    }

    fun clearError() {
        _errorMessage.value = null
    }
}
