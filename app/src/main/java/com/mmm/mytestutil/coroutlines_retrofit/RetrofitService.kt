package com.mmm.mytestutil.coroutlines_retrofit

import retrofit2.Response
import retrofit2.http.GET

interface RetrofitService {
    @GET("/posts")
    suspend fun getPosts(): Response<List<Post>>
}