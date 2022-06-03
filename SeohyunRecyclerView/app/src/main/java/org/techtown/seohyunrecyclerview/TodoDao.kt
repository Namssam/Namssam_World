package org.techtown.seohyunrecyclerview

import androidx.lifecycle.LiveData
import androidx.room.*

// 데이터베이스에 접근하기 위한 인터페이스 구현
@Dao
interface TodoDao {
    @Query("SELECT * FROM Todo")
    fun getAll(): LiveData<List<Todo>>

    @Insert
    fun insert(todo: Todo)

    @Update
    fun update(todo: Todo)

    @Delete
    fun delete(todo: Todo)
}