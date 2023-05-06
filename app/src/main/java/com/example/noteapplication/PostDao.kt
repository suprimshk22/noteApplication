package com.example.noteapplication

import androidx.lifecycle.LiveData
import androidx.room.*
import kotlin.coroutines.Continuation

//@Dao
//interface PostDao {
//
//    //    here we only defines
//    //    onConflictStrategy.igonre is for = if user add notes with same id then this will ignore the added notes(second one)
//    @Insert(onConflict = OnConflictStrategy.IGNORE)
////  suspend fun is used to run thread in background ,not to hamper ui
////  used for asyncronous
//    suspend fun insertNote(post: Post)
//    @Update
//    suspend fun updateNote(note : Post)
//    @Delete
//    suspend fun deleteNote(note : Post)
//    // below is the method to read all the notes
//    // from our database we have specified the query for it.
//    // inside the query we are arranging it in ascending
//    // order on below line and we are specifying
//    // the table name from which
//    // we have to get the data.
//    @Query("Select * from post_table order by id ASC")
////    if we are using LiveData then we dont need to add suspend as room will automatically run this in background
//    fun getAllNotes(): LiveData<List<Post>>
//    @Query("Select * from post_table order by id DESC")
//    fun getAllNotesDes(): LiveData<List<Post>>
//}
@Dao
interface PostDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPost(post: Post, continuation: Continuation<Unit>)
//
//    @Update
//    suspend fun updateUser(post: Post)
//
//    @Delete
//    suspend fun deleteUser(post: Post)
//        @Query("Select * from post_table order by id ASC")
////    if we are using LiveData then we dont need to add suspend as room will automatically run this in background
//    fun getAllPost(): LiveData<List<Post>>
//    @Query("Select * from post_table order by id DESC")
//    fun getAllNotesDes(): LiveData<List<Post>>
//
//    @Query("SELECT * FROM post_table")
//    fun getUsers(): LiveData<List<Post>>
}