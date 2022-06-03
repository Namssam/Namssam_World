package org.techtown.seohyunrecyclerview

import android.app.Application
import androidx.lifecycle.LiveData

// 데이터 소스를 접근하느데 필요한 로직을 캡슐화 하기 위한 클래스 혹은 컴포넌트
class Repository(application: Application) {

    private val todoDatabase: TodoDatabase = TodoDatabase.getInstance(application)!!
    private val todoDao: TodoDao = todoDatabase.todoDao()
    private val todos: LiveData<List<Todo>> = todoDao.getAll()

    fun getAll(): LiveData<List<Todo>> {
        return todos
    }

    fun insert(todo: Todo) {
        todoDao.insert(todo)
    }

    fun delete(todo: Todo) {
        todoDao.delete(todo)
    }
}