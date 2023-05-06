package com.example.noteapplication
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "post_table")
data class Post(
    @PrimaryKey(autoGenerate = true)
    val id:Long?,
    val Title:String,
    val Descriptiom:String,
//                @ColumnInfo(name="timeStamp")
    val TimeStamp: Long
)



