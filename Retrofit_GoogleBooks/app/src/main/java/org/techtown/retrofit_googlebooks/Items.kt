package org.techtown.retrofit_googlebooks

import com.google.gson.annotations.SerializedName

// 책 정보를 담는 데이터 클래스 생성
data class Items(

        @SerializedName("volumeInfo") var volumeInfo: VolumeInfo
)
