package org.techtown.seohyunrecyclerview

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

// 실제 접근되는 데이터베이스를 정의한다. (싱글톤 패턴 활용)
@Database(entities = [Todo::class], version = 1)
abstract class TodoDatabase: RoomDatabase() {

    abstract fun todoDao(): TodoDao

    // 싱글톤 패턴
    companion object {
        private var INSTANCE: TodoDatabase? = null

        fun getInstance(context: Context): TodoDatabase? {
            if (INSTANCE == null) {
                synchronized(TodoDatabase::class) {
                    // synchronized: 여러 스레드가 동시에 접근 불가. 동기적으로 접근
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                    TodoDatabase::class.java, "todo")
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return INSTANCE
        }
    }
}