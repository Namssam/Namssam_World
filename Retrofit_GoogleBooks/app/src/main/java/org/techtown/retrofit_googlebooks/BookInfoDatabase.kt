package org.techtown.retrofit_googlebooks

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

// 참고: https://bb-library.tistory.com/88?category=843046
abstract class BookInfoDatabase: RoomDatabase() {
    abstract fun bookInfoDao(): BookInfoDao

    // 싱글톤 패턴
    companion object{
        private var INSTANCE: BookInfoDatabase? = null

        fun getInstance(context: Context): BookInfoDatabase? {
            if (INSTANCE == null) {
                synchronized(BookInfoDatabase::class) {
                    // synchronized: 여러 스레드가 동시에 접근 불가, 동기적으로 접근
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        BookInfoDatabase::class.java, "bookInfo")
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return INSTANCE
        }
    }
}