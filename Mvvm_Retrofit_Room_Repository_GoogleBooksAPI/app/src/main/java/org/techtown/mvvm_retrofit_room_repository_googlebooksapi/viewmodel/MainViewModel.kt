package org.techtown.mvvm_retrofit_room_repository_googlebooksapi.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.techtown.mvvm_retrofit_room_repository_googlebooksapi.data.BookInfo
import org.techtown.mvvm_retrofit_room_repository_googlebooksapi.data.Items
import org.techtown.mvvm_retrofit_room_repository_googlebooksapi.repository.Repository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

//https://hanyeop.tistory.com/199
// 통신에 대한 응답을 LiveData로 처리해줌
class MainViewModel(private val repository: Repository): ViewModel() {

    val myResponse: MutableLiveData<List<Items>> = MutableLiveData()

    //https://hanyeop.tistory.com/199
    // repositoery와 뷰모델을 연결해주고 getBookInfo()를 호출해주어 통신을 요청함
    fun makeApiCall() {
        val response = repository.getBookInfo()
        response.enqueue(object : Callback<BookInfo> {
            override fun onResponse(call: Call<BookInfo>, response: Response<BookInfo>) {
                if (response.isSuccessful) {
                    myResponse.postValue(response.body()?.items)
                } else {
                    Log.d("Response", "response problem") //통신은 성공했지만 응답에 문제가 있는 경우
                }
            }

            //통신에 실패한 경우
            override fun onFailure(call: Call<BookInfo>, t: Throwable) {
                Log.d("Response", "실패")
            }
        })
    }
}