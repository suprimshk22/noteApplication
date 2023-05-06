package com.example.noteapplication.Repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.noteapplication.Api.ApiInterface
import com.example.noteapplication.PostList

class PostRepository(private val apiInterface: ApiInterface) {
    private val postLiveData= MutableLiveData<PostList>()
    val posts:LiveData<PostList>
        get() =postLiveData
    suspend fun  getPost(){
        val result=apiInterface.getPosts()
        if (result?.body()!=null){
            postLiveData.postValue(result.body())

        }
    }
}