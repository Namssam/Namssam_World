package org.techtown.seohyunrecyclerview

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

// MainViewModel은 repository 객체를 생성하고 관찰함
class MainViewModel(application: Application): AndroidViewModel(application) {
    
    private val repository = Repository(application)
    private val todos = repository.getAll()
    
    fun getAll(): LiveData<List<Todo>> {
        return repository.getAll()
    }
    
    fun insert(todo: Todo) {
        repository.insert(todo)
    }
    
    fun delete(todo: Todo) {
        repository.delete(todo)
    }
}