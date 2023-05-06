package com.example.noteapplication.ViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.noteapplication.PostList
import com.example.noteapplication.Repository.PostRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.Dispatcher

class PostViewModel(private val postRepository:PostRepository):ViewModel() {
    val data: LiveData<PostList>

    init{
       GlobalScope.launch (Dispatchers.IO){
           postRepository.getPost()

       }
         data=postRepository.posts
        


    }
}