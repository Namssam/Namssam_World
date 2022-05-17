package org.techtown.retrofit_googlebooks

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.*

// 참고: https://bb-library.tistory.com/88?category=843046
// 참고: https://hanyeop.tistory.com/199

// 레파지토리 생성
class Repository(application: Application) {

    private val bookInfoDatabase: BookInfoDatabase = BookInfoDatabase.getInstance(application)!!
    private val bookInfoDao: BookInfoDao = bookInfoDatabase.bookInfoDao()
    private val bookInfos: LiveData<List<BookInfo>> = bookInfoDao.getAll()

    private val rtfBuilder: Retrofit = RetrofitBuilder.getRetrofit()
    private val api = rtfBuilder.create(RetrofitInterface::class.java)


    fun getBookData(): LiveData<List<Items>?> {
        val data = MutableLiveData<List<Items>?>()

        api.getBookInfo().enqueue(object : Callback<BookInfo> {
            override fun onResponse(call: Call<BookInfo>, response: Response<BookInfo>) {

                data.value = response.body()?.items
            }

            override fun onFailure(call: Call<BookInfo>, t: Throwable) {
                t.stackTrace
            }
        })

        return data
    }

    fun getAll(): LiveData<List<BookInfo>>{
        return bookInfos
    }

    fun insert(bookInfo: Items){
        bookInfoDao.insert(bookInfo)
    }
    fun delete(bookInfo: Items){
        bookInfoDao.delete(bookInfo)
    }

}