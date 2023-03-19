package com.example.libraryseatreservation.ui.notifications

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.libraryseatreservation.MainActivity
import com.example.libraryseatreservation.databinding.FragmentNotificationsBinding
import com.example.libraryseatreservation.ui.login.LoginActivity
import com.github.testpress.mikephil.charting.charts.PieChart
import com.github.testpress.mikephil.charting.data.PieData
import com.github.testpress.mikephil.charting.data.PieDataSet
import com.github.testpress.mikephil.charting.data.PieEntry
import com.github.testpress.mikephil.charting.formatter.PercentFormatter
import com.github.testpress.mikephil.charting.utils.ColorTemplate

class NotificationsFragment : Fragment() {

    private var _binding: FragmentNotificationsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private var pieChart : PieChart?= null
    private var chartContainer: FrameLayout?= null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val notificationsViewModel =
            ViewModelProvider(this).get(NotificationsViewModel::class.java)

        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        val root: View = binding.root
        chartContainer = binding.chartContainer
        binding.quit.setOnClickListener {
            activity?.let { it1 -> LoginActivity.newInstance(it1, 1) }
        }
        initChartView()
        initChartData()
        return root
    }

    private fun initChartView() {
        pieChart = PieChart(context)
        pieChart?.apply {
            val lp = FrameLayout.LayoutParams(1000, 1000)
            layoutParams = lp
        }
        chartContainer?.addView(pieChart)
    }

    private fun initChartData() {
        val values = arrayListOf<PieEntry>()
        values.add(PieEntry(40f, "3h及以上"))
        values.add(PieEntry(20f, "2h-3h"))
        values.add(PieEntry(30f, "1h-2h"))
        values.add(PieEntry(10f, "1h以下"))

        //数据和颜色
        val dataColors = arrayListOf<Int>()
        for (c in ColorTemplate.VORDIPLOM_COLORS) dataColors.add(c)
        for (c in ColorTemplate.JOYFUL_COLORS) dataColors.add(c)
        for (c in ColorTemplate.COLORFUL_COLORS) dataColors.add(c)
        for (c in ColorTemplate.LIBERTY_COLORS) dataColors.add(c)
        for (c in ColorTemplate.PASTEL_COLORS) dataColors.add(c)
        dataColors.add(ColorTemplate.getHoloBlue())
        val mPieDataSet = PieDataSet(values, "Label")
        mPieDataSet.apply {
            valueFormatter = PercentFormatter()
            colors = dataColors
            valueTextColor = Color.BLACK // 设置百分比字体颜色
            valueTextSize = 20f // 设置百分比字体大小
        }
        val mPieData = PieData(mPieDataSet)
        pieChart?.setEntryLabelColor(Color.BLACK) // 设置图表扇形文字颜色
        pieChart?.data = mPieData
    }
}