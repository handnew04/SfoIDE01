package com.example.userlistapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.userlistapp.R
import com.example.userlistapp.data.Result
import com.example.userlistapp.databinding.ItemMainBinding

class MainRecyclerAdapter : RecyclerView.Adapter<MainRecyclerAdapter.ViewHolder>() {
    private var userList: ArrayList<Result> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DataBindingUtil.inflate<ItemMainBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_main,
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = userList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = userList[position]
        holder.bind(item)
    }

    fun setItemList(list: ArrayList<Result>) {
        userList.clear()
        userList.addAll(list)
        notifyDataSetChanged()
    }

    inner class ViewHolder(val binding: ItemMainBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(userInfo: Result) {
            binding.userInfo = userInfo
        }
    }
}


