package org.techtown.mvvm_retrofit_room_repository_googlebooksapi.data

import com.google.gson.annotations.SerializedName

// 저자, 썸네일, 상세링크, 출판사, 출판일. 제목을 담고 있는 데이터클래스

data class VolumeInfo(
    @SerializedName("authors")
    val authors: List<String?>,

    @SerializedName("imageLinks")
    val imageLinks: ImageLinks?,

    @SerializedName("infoLink")
    val infoLink: String?,

    @SerializedName("publishedDate")
    val publishedDate: String?,

    @SerializedName("publisher")
    val publisher: String?,

    @SerializedName("title")
    val title: String?
)