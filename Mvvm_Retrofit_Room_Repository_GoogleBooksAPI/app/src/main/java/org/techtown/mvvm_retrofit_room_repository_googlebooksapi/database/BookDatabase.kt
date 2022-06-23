package org.techtown.mvvm_retrofit_room_repository_googlebooksapi.database
/*
import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

// 참고: https://bb-library.tistory.com/88?category=843046
abstract class BookDatabase: RoomDatabase() {
    abstract fun bookInfoDao(): BookDao

    // 싱글톤 패턴
    companion object{
        private var INSTANCE: BookDatabase? = null

        fun getInstance(context: Context): BookDatabase? {
            if (INSTANCE == null) {
                synchronized(BookDatabase::class) {
                    // synchronized: 여러 스레드가 동시에 접근 불가, 동기적으로 접근
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        BookDatabase::class.java, "bookInfo")
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return INSTANCE
        }
    }
}
 */

