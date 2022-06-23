package org.techtown.mvvm_retrofit_room_repository_googlebooksapi.data


import com.google.gson.annotations.SerializedName

// VolumeInfo를 담고 있는 데이터 클래스

data class Items(
    @SerializedName("volumeInfo")
    val volumeInfo: VolumeInfo
)
