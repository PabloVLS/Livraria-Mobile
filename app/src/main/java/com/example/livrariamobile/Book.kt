package com.example.livrariamobile

import android.os.Parcel
import android.os.Parcelable

data class Book(
    val id: String,
    val title: String,
    val author: String,
    val description: String,
    val coverImageUrl: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(title)
        parcel.writeString(author)
        parcel.writeString(description)
        parcel.writeString(coverImageUrl)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Book> {
        override fun createFromParcel(parcel: Parcel) = Book(parcel)
        override fun newArray(size: Int) = arrayOfNulls<Book>(size)
    }
}
