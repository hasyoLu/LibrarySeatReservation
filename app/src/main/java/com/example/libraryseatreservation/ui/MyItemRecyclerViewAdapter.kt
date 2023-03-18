package com.example.libraryseatreservation.ui

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.libraryseatreservation.bean.ItemBean
import com.example.libraryseatreservation.databinding.FragmentItemBinding

import com.example.libraryseatreservation.ui.placeholder.PlaceholderContent.PlaceholderItem

/**
 * [RecyclerView.Adapter] that can display a [PlaceholderItem].
 * TODO: Replace the implementation with code for your data type.
 */
class MyItemRecyclerViewAdapter(
        private val values: List<ItemBean>)
    : RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

    return ViewHolder(FragmentItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        val binding : FragmentItemBinding = holder.binding
        if(!item.isUnFinish) {
            binding.button1.visibility = View.GONE
        }
        binding.weizhi.text = item.weiZhi
        binding.number.text = item.number
        binding.time.text = item.time
        binding.longer.text = item.long
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(val binding: FragmentItemBinding) : RecyclerView.ViewHolder(binding.root)

}