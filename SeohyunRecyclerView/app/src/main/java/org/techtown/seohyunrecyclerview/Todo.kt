package org.techtown.seohyunrecyclerview

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Todo (
        // autoGenerate는 null값을 받으면 ID 값을 자동으로 할당해줌
        @PrimaryKey(autoGenerate = true)
        var id: Int?,

        @ColumnInfo(name = "title")
        var title: String,

        @ColumnInfo(name = "content")
        var content: String

        )

{
        constructor(): this(null, "", "")
}