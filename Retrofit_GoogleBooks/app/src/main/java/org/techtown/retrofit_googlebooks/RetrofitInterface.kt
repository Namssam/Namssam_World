package org.techtown.retrofit_googlebooks

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

// Retrofit을 통해 통신할 인터페이스
interface RetrofitInterface {
    @GET("books/v1/volumes?q=코틀린")
    // suspend fun을 해야 에러가 안남.. 찾아볼 것!@!!!(java.lang.IllegalArgumentException: Unable to create call adapter for class)
    fun getBookInfo(
    ): Call<BookInfo> // 반환되는 값 -> BookInfo

    /*
    @GET("books/v1/volumes?q=코틀린")
    fun getBookInfo(): retrofit2.Call<List<BookInfo>>
    */

    /*
    // 책 정보를 가져오는 메서드 정의
    fun getBookInfo(): BookInfo
    */

    /*
    fun getBookInfo(
        // 어떤걸 적어야 할까....
        @Header("volumInfo") volumeInfo: List<VolumeInfo>,
        @Header("imageLinks") imageLinks: List<ImageLinks>,
        @Header("infoLink") infoLink: String
    )
    */

}