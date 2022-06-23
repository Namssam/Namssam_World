package org.techtown.mvvm_retrofit_room_repository_googlebooksapi.data

//import androidx.room.Entity
import com.google.gson.annotations.SerializedName

// @Entity를 해줘야 Dao에서 오류가 안남
// 제일 큰 Data집합
//@Entity
data class BookInfo(
    @SerializedName("items") val items: List<Items>
)
