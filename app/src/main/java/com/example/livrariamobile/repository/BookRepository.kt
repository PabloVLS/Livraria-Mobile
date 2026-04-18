package com.example.livrariamobile.repository

import android.util.Log
import com.example.livrariamobile.api.GoogleBooksResponse
import com.example.livrariamobile.api.GoogleBooksService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object BookRepository {
    private val httpClient = OkHttpClient.Builder()
        .connectTimeout(15, java.util.concurrent.TimeUnit.SECONDS)
        .readTimeout(15, java.util.concurrent.TimeUnit.SECONDS)
        .writeTimeout(15, java.util.concurrent.TimeUnit.SECONDS)
        .addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        })
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://www.googleapis.com/books/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(httpClient)
        .build()

    private val googleBooksApi = retrofit.create(GoogleBooksService::class.java)

    suspend fun searchBooks(query: String): GoogleBooksResponse {
        return try {
            Log.d("BookRepository", "Searching for: $query")
            val response = googleBooksApi.searchBooks(query)
            Log.d("BookRepository", "Response received with ${response.items?.size ?: 0} items")
            response
        } catch (e: Exception) {
            Log.e("BookRepository", "API Error: ${e.message}", e)
            e.printStackTrace()
            GoogleBooksResponse()
        }
    }
}


