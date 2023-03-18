package com.example.libraryseatreservation.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.libraryseatreservation.R
import com.example.libraryseatreservation.bean.ItemBean
import com.example.libraryseatreservation.ui.placeholder.PlaceholderContent
import java.text.SimpleDateFormat
import java.util.*

/**
 * A fragment representing a list of Items.
 */
class ItemFragment : Fragment() {

    private var status = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            status = it.getInt(STATUS)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_item_list, container, false)

        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = LinearLayoutManager(context)
                adapter = if (status == STATUS_FINISH) {
                    MyItemRecyclerViewAdapter(getFinishDate())
                } else {
                    MyItemRecyclerViewAdapter(getUnFinishDate())
                }
            }
        }
        return view
    }

    private val str1 = "座位号 : "
    private val str2 = "订座时间 : "
    private val str3 = "订座时长 : "

    fun getFinishDate(): List<ItemBean> {
        return listOf<ItemBean>(
            ItemBean("西安邮电大学东区8楼", str1+"A区44号", str2+"2022-11-28  18:00", str3+"2小时"),
            ItemBean("西安邮电大学图书馆2楼", str1+"B区10号", str2+"2022-11-21  15:00", str3+"1小时"),
            ItemBean("西安邮电大学东区8楼", str1+"b区24号", str2+"2022-11-1  10:00", str3+"2小时"),
            ItemBean("西安邮电大学东区8楼", str1+"C区44号", str2+"2022-10-28  18:00", str3+"2小时"),
            ItemBean("西安邮电大学东区8楼", str1+"A区44号", str2+"2022-10-26  14:00", str3+"1小时"),
            ItemBean("西安邮电大学图书馆3楼", str1+"A区44号", str2+"2022-10-25  12:00", str3+"1小时"),
            ItemBean("西北政法大学图书馆", str1+"A区44号", str2+"2022-10-24  15:00", str3+"3小时"),
            ItemBean("西安邮电大学图书馆2楼", str1+"A区44号", str2+"2022-10-23  17:00", str3+"5小时"),
            ItemBean("西安邮电大学东区8楼", str1+"A区44号", str2+"2022-10-22  19:00", str3+"3小时"),
            ItemBean("西安邮电大学东区8楼", str1+"A区44号", str2+"2022-10-21  9:00", str3+"2小时")
        )
    }

    fun getUnFinishDate(): List<ItemBean> {
        val dateFormat = SimpleDateFormat( "yyyy-MM-dd  HH:mm")
        return listOf(ItemBean("西安邮电大学东区8楼", str1+"A区10号", str2+dateFormat.format(Date()), str3+"3小时", true))
    }

    companion object {
        const val STATUS = "status"
        const val STATUS_FINISH= 0
        const val STATUS_UNFINISH = 1
        @JvmStatic
        fun newInstance(status: Int) =
                ItemFragment().apply {
                    arguments = Bundle().apply {
                        putInt(STATUS, status)
                    }
                }
    }
}