package com.example.noteapplication

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
@Database(entities = [Post::class], version = 1)
abstract class PostDatabase: RoomDatabase() {
    abstract  fun getPostDao():PostDao
    companion object{
        //         @Volatile is used so that if anything changes (inser,update or delete this will nofity)
        @Volatile
        private var INSTANCE:PostDatabase?=null
        fun getDatabase(context: Context) {
            if (INSTANCE==null) {
//                need to wrap in synchoronized becoz at the same time db banako huna sakcha so to be prevent from that
                synchronized(this) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        PostDatabase::class.java,
                        "note_database"
                    ).build()
                }
            }}
    }
}