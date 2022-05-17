package org.techtown.retrofit_googlebooks

import android.app.Application
import androidx.lifecycle.*

// https://hanyeop.tistory.com/199 참고
// 참고: https://bb-library.tistory.com/89?category=843046

class MainViewModel(application: Application): AndroidViewModel(application) {
    private val repository = Repository(application)
    private val bookInfos = repository.getBookData()

    val myResponse: MutableLiveData<Items> = MutableLiveData()

    fun getAll() : LiveData<List<BookInfo>> {
        return repository.getAll()
    }

    fun insert(bookInfo: Items){
        repository.insert(bookInfo)
    }
    fun delete(bookInfo: Items){
        repository.delete(bookInfo)
    }

    fun getBookInfo():LiveData<List<Items>?> {
        return bookInfos
    }
}