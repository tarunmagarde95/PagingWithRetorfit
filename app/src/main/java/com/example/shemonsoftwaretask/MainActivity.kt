package com.example.shemonsoftwaretask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.contentcapture.DataShareWriteAdapter
import android.widget.ProgressBar
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shemonsoftwaretask.ViewModel.DataViewModel
import com.example.shemonsoftwaretask.dataadapter.DataAdapter
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val viewModel: DataViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        val adapter = DataAdapter()



        lifecycleScope.launch {
            viewModel.pagedPosts.collectLatest { pagingData ->
                adapter.submitData(pagingData)
            }
        }


        recyclerView.layoutManager = LinearLayoutManager(this)

        recyclerView.adapter = adapter



    }
}