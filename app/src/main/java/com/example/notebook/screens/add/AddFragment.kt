package com.example.notebook.screens.add

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.notebook.APP
import com.example.notebook.R
import com.example.notebook.databinding.FragmentAddBinding
import com.example.notebook.databinding.FragmentStartBinding
import com.example.notebook.model.Model


class AddFragment : Fragment() {

    lateinit var binding:FragmentAddBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentAddBinding.inflate(layoutInflater, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this).get(AddViewModel::class.java)
        binding.btnAdd.setOnClickListener{
            //получаем данные со строк
           val titleText = binding.editTextTextPersonName.text.toString()
            val descriptionText = binding.editTextTextPersonName2.text.toString()

        viewModel.insert(Model(title = titleText, discription = descriptionText)){}
            APP.navController.navigate(R.id.action_addFragment_to_startFragment)
        }
        binding.btnBack.setOnClickListener{
            APP.navController.navigate(R.id.action_addFragment_to_startFragment)
            }
    }
}