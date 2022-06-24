package org.techtown.mvvm_retrofit_room_repository_googlebooksapi.api

import org.techtown.mvvm_retrofit_room_repository_googlebooksapi.data.BookInfo
import retrofit2.Call
import retrofit2.http.GET

// 출처: https://hanyeop.tistory.com/199
interface BookApi {
    @GET("books/v1/volumes?q=jiujitsu")
    fun getBookInfo(): Call<BookInfo>
}