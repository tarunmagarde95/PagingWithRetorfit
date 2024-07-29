package com.example.shemonsoftwaretask.Api

import com.example.shemonsoftwaretask.model.DataModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("posts")
    suspend fun getData(
        @Query("_page") page: Int,
        @Query("_limit") limit: Int
    ): Response<List<DataModel>>
}