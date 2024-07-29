package com.example.shemonsoftwaretask.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.example.shemonsoftwaretask.Api.RetrofitInstance
import com.example.shemonsoftwaretask.Pagination.PostPagingSource
import com.example.shemonsoftwaretask.model.DataModel

class DataRepository() {

    private val apiService = RetrofitInstance.apiService

    fun getPagedPosts(): Pager<Int, DataModel> {
        return Pager(
            config = PagingConfig(pageSize = 20, enablePlaceholders = false),
            pagingSourceFactory = { PostPagingSource(apiService) }
        )
    }
}