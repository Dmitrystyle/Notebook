package com.example.notebook.screens.dataile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.notebook.APP
import com.example.notebook.R
import com.example.notebook.databinding.FragmentDatailBinding
import com.example.notebook.databinding.FragmentStartBinding
import com.example.notebook.model.Model


class DatailFragment : Fragment() {

    lateinit var  binding: FragmentDatailBinding
    lateinit var curentNote: Model

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentDatailBinding.inflate(layoutInflater, container,false)
        curentNote = arguments?.getSerializable("note") as Model
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this).get(DatailViewModel::class.java)
        binding.textTitle.text = curentNote.title
        binding.textDatail.text = curentNote.discription

        binding.btnBack.setOnClickListener {
            APP.navController.navigate(R.id.action_datailFragment_to_startFragment)
        }

        binding.btnDelet.setOnClickListener {
            viewModel.delete(curentNote){}
            APP.navController.navigate(R.id.action_datailFragment_to_startFragment)
        }
    }

}