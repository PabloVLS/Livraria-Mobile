package com.example.livrariamobile.api

import com.google.gson.annotations.SerializedName

// Resposta principal da API
data class GoogleBooksResponse(
    @SerializedName("items")
    val items: List<BookItem>? = null,
    @SerializedName("totalItems")
    val totalItems: Int? = null
)

// Item de livro da API
data class BookItem(
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("volumeInfo")
    val volumeInfo: VolumeInfo? = null
)

// Informacoes do volume/livro
data class VolumeInfo(
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("authors")
    val authors: List<String>? = null,
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("imageLinks")
    val imageLinks: ImageLinks? = null,
    @SerializedName("publishedDate")
    val publishedDate: String? = null,
    @SerializedName("publisher")
    val publisher: String? = null
)

// Links de imagens
data class ImageLinks(
    @SerializedName("smallThumbnail")
    val smallThumbnail: String? = null,
    @SerializedName("thumbnail")
    val thumbnail: String? = null
)
