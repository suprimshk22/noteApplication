package com.example.noteapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.noteapplication.Api.ApiInterface
import com.example.noteapplication.Api.ApiUtilities
import com.example.noteapplication.Repository.PostRepository
import com.example.noteapplication.ViewModel.PostViewModel
import com.example.noteapplication.ViewModel.PostViewModelFactory
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var database:PostDatabase
        val apiInstance=ApiUtilities.getInstance().create(ApiInterface::class.java)
        val postRepository=PostRepository(apiInstance)
        val postViewModels=ViewModelProvider(this, PostViewModelFactory(postRepository)).get(PostViewModel::class.java)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        postViewModels.data.observe(this) {
            Log.i("APiDATA", "$it.toString()")
        }
//GlobalScope.lunch is for the coroutine to run this thread in another thread which will be run in background which wont hamper main thread
//        GlobalScope.launch(){
//            database.getPostDao().getDatabase((Post(0,"ssas","Asdfasdf",202219199)))
//
//        }

    }
}