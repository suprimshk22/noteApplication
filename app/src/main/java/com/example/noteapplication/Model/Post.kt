package com.example.noteapplication

data class PostList(
var userId:Int,
var id:Int,
var title:String,
var body:String,
) {
    operator fun invoke(body: PostList) {

    }
}
