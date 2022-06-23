package org.techtown.mvvm_retrofit_room_repository_googlebooksapi.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.techtown.mvvm_retrofit_room_repository_googlebooksapi.repository.Repository

//https://hanyeop.tistory.com/199
// 뷰모델에서 파라미터로 Repository를 받아야 하기 때문에 Factory를 생성해줌
class MainViewModelFactory(
    private var repository: Repository): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }
}