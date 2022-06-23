package org.techtown.mvvm_retrofit_room_repository_googlebooksapi.repository

import org.techtown.mvvm_retrofit_room_repository_googlebooksapi.data.BookInfo
import org.techtown.mvvm_retrofit_room_repository_googlebooksapi.api.RetrofitInstance
import org.techtown.mvvm_retrofit_room_repository_googlebooksapi.data.VolumeInfo
import retrofit2.Call
import retrofit2.Response

// https://hanyeop.tistory.com/199
// MVVM 패턴을 위해 데이터 통신을 하는 Repository를 생성
// 여기서 통신한 값을 ViewModel에 사용할 것
class Repository {

     fun getBookInfo(): Call<BookInfo> {
        // BookApi의 getBookInfo 타입을 Call<BookInfo>로 해줘야 오류가 안남
        return RetrofitInstance.api.getBookInfo()
    }
}