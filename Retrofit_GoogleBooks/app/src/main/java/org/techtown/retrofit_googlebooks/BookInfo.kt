package org.techtown.retrofit_googlebooks

import com.google.gson.annotations.SerializedName

data class BookInfo(
    @SerializedName("items") val items: List<Items>
)

