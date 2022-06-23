package org.techtown.mvvm_retrofit_room_repository_googlebooksapi.api

import org.techtown.mvvm_retrofit_room_repository_googlebooksapi.data.BookInfo
import org.techtown.mvvm_retrofit_room_repository_googlebooksapi.data.VolumeInfo
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface BookApi {

    @GET("books/v1/volumes?q=jiujitsu")
    fun getBookInfo(): Call<BookInfo>
}