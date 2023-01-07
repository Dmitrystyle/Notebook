package com.example.notebook.screens.add

import android.app.TimePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TimePicker
import androidx.lifecycle.ViewModelProvider
import com.example.notebook.APP
import com.example.notebook.R
import com.example.notebook.data.dataPicker.DatePickerFragment
import com.example.notebook.databinding.FragmentAddBinding
import com.example.notebook.databinding.FragmentStartBinding
import com.example.notebook.model.Model
import java.text.SimpleDateFormat
import java.util.*


class AddFragment : Fragment() {

    lateinit var binding:FragmentAddBinding

    private var selectedHour = 0
    private var selectedMinute = 0

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
            //val time1=binding.editTextTime.t

        viewModel.insert(Model(title = titleText, discription = descriptionText, time1 = 4)){}
            APP.navController.navigate(R.id.action_addFragment_to_startFragment)
        }
        binding.btnBack.setOnClickListener{
            APP.navController.navigate(R.id.action_addFragment_to_startFragment)
            }


        binding.btnEditTime.setOnClickListener{
            val datePickerFragment = DatePickerFragment()
            val supportFragmentManager = requireActivity().supportFragmentManager
            // show
            datePickerFragment.show(supportFragmentManager, "DatePickerFragment")
        }


        val supportFragmentManager = requireActivity().supportFragmentManager

        // we have to implement setFragmentResultListener
        supportFragmentManager.setFragmentResultListener(
            "REQUEST_KEY",
            viewLifecycleOwner
        ) { resultKey, bundle ->
            if (resultKey == "REQUEST_KEY") {
                val date = bundle.getString("SELECTED_DATE")

                binding.textTimeFirst.text=date
            }
        }

    }

}