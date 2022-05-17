package org.techtown.retrofit_googlebooks

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

// Retrofit 객체 만들기!
object RetrofitBuilder {

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
    
    // 클래스 멤버로 만들기 위해 companion object 사용
    // https://velog.io/@cmjh951330/restrofit2-method 참고
    // companion object -> 다른 클래스에서
    /*
    companion object {
        val retrofit: Retrofit = Retrofit.Builder()
            // 통신할 서버 url
            .baseUrl("https://www.googleapis.com/")
            // Json을 Gson 형태로 변환해주는 요소
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        // Retrofit을 통해 통신할 인터페이스
        val rtfInterface: RetrofitInterface = retrofit.create(RetrofitInterface::class.java)
   }

     */
}
