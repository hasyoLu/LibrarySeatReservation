package com.example.libraryseatreservation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.libraryseatreservation.databinding.FragmentXuanBinding
import com.example.libraryseatreservation.ui.home.*

class XuanFragment : Fragment() {

    private lateinit var viewModel: XuanViewModel
    private var _binding: FragmentXuanBinding? = null



    private val binding get() = _binding!!
    private var weizhi: String = ""
    private var keyonmg: String = ""
    private var total: String = ""

    private val COLUMNS = 5
    private var txtSeatSelected: TextView? = null
    private lateinit var  recyclerView: RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentXuanBinding.inflate(inflater, container, false)

        arguments?.let {
            weizhi = it.getString("str1", "西安邮电大学")
            keyonmg = "30"
            total = "150"
        }
        txtSeatSelected = binding.txtSeatSelected
        binding.back.setOnClickListener {
            findNavController().popBackStack()
        }

        val items: MutableList<AbstractItem> = ArrayList<AbstractItem>()
        for (i in 0..29) {
            if (i % COLUMNS == 0 || i % COLUMNS == 4) {
                items.add(EdgeItem(i.toString()))
            } else if (i % COLUMNS == 1 || i % COLUMNS == 3) {
                items.add(CenterItem(i.toString()))
            } else {
                items.add(EmptyItem(i.toString()))
            }
        }
        val adapter = AirplaneAdapter(context, items)

        recyclerView = binding.lstItems
        recyclerView.layoutManager = GridLayoutManager(context, COLUMNS)
        recyclerView.adapter = adapter

        txtSeatSelected?.setOnClickListener {
            Toast.makeText(context, "选座成功", Toast.LENGTH_LONG).show()
            findNavController().popBackStack()
        }
        return binding.root
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(XuanViewModel::class.java)
        // TODO: Use the ViewModel
    }

}