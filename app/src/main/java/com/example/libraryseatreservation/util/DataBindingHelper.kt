package com.example.libraryseatreservation.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.example.libraryseatreservation.base.BaseApplication.Companion.getContext


/**
 * author : Haa-zzz
 * time : 2021/8/1
 * 处理图片，把获取到的 base64编码的图片 转换为Bitmap 并通过 DataBinding的适配器来添加进去
 */
//@BindingAdapter("imgUrl")
//fun loadImage(imageView: ImageView?, base64Image : String?) {
//    if(base64Image != null){
//        val bitmap = base64Decode(base64Image)
//        imageView?.setImageBitmap(bitmap)
//    }
//}
//
//
//@BindingAdapter("urlImage")
//private fun loadUrlImage(imageView: ImageView?, url : String?){
//    if(imageView == null || url == null)
//        return
//
//    Glide.with(getContext())
//        .load(url)
//        .into(imageView)
//}

/**
 * author : Haa-zzz
 * time : 2021/8/2
 * 处理RecyclerView，直接传入list,通过这里来适配到对应的Adapter
 */

//@BindingAdapter("recyclerViewList")
//fun loadRecyclerView(recyclerView: RecyclerView?, list: ObservableArrayList<PlanRoom>?) {
//
//    if(list != null && !list.isEmpty() ){
//        val arraylist = list.toMutableList() as ArrayList<PlanRoom>
//        recyclerView?.adapter = PlanAdapter(arraylist)
//    }
//}
