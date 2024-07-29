package com.example.shemonsoftwaretask.dataadapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.shemonsoftwaretask.R
import com.example.shemonsoftwaretask.model.DataModel

class DataAdapter : PagingDataAdapter<DataModel, DataViewHolder>(DIFF_CALLBACK) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_data, parent, false)
        return DataViewHolder(view)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val item = getItem(position)
        if (item != null) {
            holder.title.text = item.title
            holder.desciption.text = item.body
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<DataModel>() {
            override fun areItemsTheSame(oldItem: DataModel, newItem: DataModel): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: DataModel, newItem: DataModel): Boolean {
                return oldItem == newItem
            }
        }
    }
}

class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    // Bind data to views
    val title: TextView = itemView.findViewById(R.id.title)
    val desciption: TextView = itemView.findViewById(R.id.body)
    /*fun bind(post: DataModel) {

    }*/
}


