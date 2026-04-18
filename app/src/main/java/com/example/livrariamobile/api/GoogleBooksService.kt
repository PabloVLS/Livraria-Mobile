package com.example.livrariamobile.api

import retrofit2.http.GET
import retrofit2.http.Query

interface GoogleBooksService {
    @GET("v1/volumes")
    suspend fun searchBooks(
        @Query("q") query: String,
        @Query("maxResults") maxResults: Int = 20,
        @Query("key") apiKey: String = "AIzaSyCuyz6z3cvOVSFvvP7TinojAf-RxMdNrbM"
    ): GoogleBooksResponse
}
