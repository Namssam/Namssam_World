package org.techtown.mvvm_retrofit_room_repository_googlebooksapi.data


import com.google.gson.annotations.SerializedName

// 썸네일 정보를 담는 데이터 클래스 생성

data class ImageLinks(

    @SerializedName("thumbnail")
    val thumbnail: String?
)
