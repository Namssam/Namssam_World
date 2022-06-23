package org.techtown.mvvm_retrofit_room_repository_googlebooksapi.api

import retrofit2.CallAdapter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// https://hanyeop.tistory.com/199
// object로 싱글톤 패턴으로 객체를 생성해줌
// 둘 다 by lazy로 늦은 초기화 해줌으로써, api 변수가 사용될 때 초기화되고,
// 그 안에서 retrofit 변수를 사용하기 때문에 초기화 된다.
object RetrofitInstance {

    // Retrofit.Builder 클래스로 baseUrl과 Converter 설정
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://www.googleapis.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: BookApi by lazy {
        retrofit.create(BookApi::class.java)
    }
/*
    private var retrofit: Retrofit? = null

    fun getRetrofit(): Retrofit {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl("https://www.googleapis.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit!!
    }
    */


}