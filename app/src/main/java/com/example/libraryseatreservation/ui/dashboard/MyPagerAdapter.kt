package com.example.libraryseatreservation.ui.dashboard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.libraryseatreservation.R

class MyPagerAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val mData = arrayListOf<Int>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.adapter_page,parent,false))
    }

    override fun getItemCount(): Int = mData.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is MyViewHolder) {
            holder.setData(mData[position])
        }
    }

    fun setData(data:List<Int>) {
        mData.clear()
        mData.addAll(data)
        notifyDataSetChanged()
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var img:ImageView ?= null
        init {
            img = itemView.findViewById(R.id.img)
        }
        fun setData(resId: Int) {
            img?.setImageDrawable(itemView.resources.getDrawable(resId))
        }
    }
}