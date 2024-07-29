package com.example.shemonsoftwaretask.Pagination

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.shemonsoftwaretask.Api.ApiService

import com.example.shemonsoftwaretask.model.DataModel

class PostPagingSource(private val apiService: ApiService) : PagingSource<Int, DataModel>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, DataModel> {
        return try {
            val currentPage = params.key ?: 1
            val response = apiService.getData(currentPage, params.loadSize)
            val data = response.body() ?: emptyList()
            LoadResult.Page(
                data = data,
                prevKey = if (currentPage == 1) null else currentPage - 1,
                nextKey = if (data.isEmpty()) null else currentPage + 1
            )
        } catch (exception: Exception) {
            LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, DataModel>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}
