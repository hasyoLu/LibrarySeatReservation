package com.example.libraryseatreservation.ui.home

import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.libraryseatreservation.R
import com.example.libraryseatreservation.bean.HomeItemBean
import com.example.libraryseatreservation.databinding.ItemTuBinding

import com.example.libraryseatreservation.ui.placeholder.PlaceholderContent.PlaceholderItem

/**
 * [RecyclerView.Adapter] that can display a [PlaceholderItem].
 * TODO: Replace the implementation with code for your data type.
 */
class HomeRecyclerViewAdapter(
        private val values: List<HomeItemBean>)
    : RecyclerView.Adapter<HomeRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemTuBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        val binding : ItemTuBinding = holder.binding
        binding.weizhi.text = item.weiZhi
        binding.keyong.text = item.keYong
        binding.root.setOnClickListener {
           listener.invoke(position)
        }
    }
    override fun getItemCount(): Int = values.size

    inner class ViewHolder(val binding: ItemTuBinding) : RecyclerView.ViewHolder(binding.root)

    fun setClickListener(listener: (pos: Int) -> Unit) {
        this.listener = listener
    }

    private lateinit var listener: (pos: Int) -> Unit

}