package org.techtown.retrofit_googlebooks

import com.google.gson.annotations.SerializedName

data class VolumeInfo (
    @SerializedName("authors")
    val authors: List<String>,

    @SerializedName("imageLinks")
    val imageLinks: ImageLinks,

    @SerializedName("infoLink")
    val infoLink: String,

    @SerializedName("publishedDate")
    val publishedDate: String,

    @SerializedName("publisher")
    val publisher: String,

    @SerializedName("title")
    val title: String
        )