package com.example.shemonsoftwaretask.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.shemonsoftwaretask.model.DataModel
import com.example.shemonsoftwaretask.repository.DataRepository
import kotlinx.coroutines.flow.Flow

class DataViewModel : ViewModel() {
    private val repository = DataRepository()
    val pagedPosts: Flow<PagingData<DataModel>> = repository.getPagedPosts().flow.cachedIn(viewModelScope)
}