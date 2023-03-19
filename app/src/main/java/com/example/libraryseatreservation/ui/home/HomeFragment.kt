package com.example.libraryseatreservation.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.libraryseatreservation.R
import com.example.libraryseatreservation.bean.HomeItemBean
import com.example.libraryseatreservation.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        initRecyclerView()
        return root
    }

    private fun initRecyclerView() {
        recyclerView = binding.itemTu
        recyclerView.apply {
            layoutManager =  LinearLayoutManager(context)
            adapter = HomeRecyclerViewAdapter(getDateList()).apply {
                setClickListener {
                    val bundle = Bundle()
                    bundle.putString("str1", getDateList()[it].weiZhi)
                    bundle.putString("str2",getDateList()[it].keYong)
                    Navigation.findNavController(requireView()).navigate(R.id.action_navigation_plan_to_richEditView,bundle)
                }
            }
        }
    }

    private fun getDateList(): List<HomeItemBean> {
        return listOf(
            HomeItemBean("东区8楼大厅", "90/150"),
            HomeItemBean("东区8楼走廊1", "10/70"),
            HomeItemBean("东区8楼走廊2", "20/70"),
            HomeItemBean("东区1楼fz151", "30/60"),
            HomeItemBean("图书馆-1层", "45/150"),
            HomeItemBean("图书馆1层", "34/160"),
            HomeItemBean("图书馆2层", "90/150"),
            HomeItemBean("图书馆3层", "100/120"),
            HomeItemBean("图书馆4层", "70/100"),
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}