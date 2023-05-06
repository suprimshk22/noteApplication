package com.example.noteapplication.Api

import com.example.noteapplication.PostList
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET("/posts")
    suspend fun getPosts(): Response<PostList>
}