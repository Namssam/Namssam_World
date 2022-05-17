package org.techtown.retrofit_googlebooks

import androidx.lifecycle.LiveData
import androidx.room.*

// 참고: https://bb-library.tistory.com/88?category=843046
@Suppress("AndroidUnresolvedRoomSqlReference")
@Dao
interface BookInfoDao {

    @Query("SELECT * FROM BookInfo")
    fun getAll(): LiveData<List<BookInfo>>

    @Insert
    fun insert(bookInfo: Items)

    @Update
    fun update(bookInfo: BookInfo)

    @Delete
    fun delete(bookInfo: Items)

}