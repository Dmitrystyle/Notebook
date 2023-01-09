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
import com.example.notebook.data.dataPicker.TimePikerFragment
import com.example.notebook.databinding.FragmentAddBinding
import com.example.notebook.databinding.FragmentStartBinding
import com.example.notebook.model.Model
import java.text.SimpleDateFormat
import java.util.*


class AddFragment : Fragment() {

    lateinit var binding:FragmentAddBinding

    private var detaText = ""

    private var timeText = ""


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


//_________данные о времени____________

        binding.btnEditTime.setOnClickListener{
            val datePickerFragment = DatePickerFragment()
            val supportFragmentManager = requireActivity().supportFragmentManager
            // show
            datePickerFragment.show(supportFragmentManager, "DatePickerFragment")
        }

//___________________передача данных о дате____________________
        val supportFragmentManager = requireActivity().supportFragmentManager

        // we have to implement setFragmentResultListener
        supportFragmentManager.setFragmentResultListener(
            "REQUEST_KEY",
            viewLifecycleOwner
        ) { resultKey, bundle ->
            if (resultKey == "REQUEST_KEY") {
                val date = bundle.getString("SELECTED_DATE")
                detaText=date.toString()
            }
        }

        //___________________передаем  - время___

        binding.btnEditHourMin.setOnClickListener{
            val timePickerFragment = TimePikerFragment()
            val supportFragmentManager = requireActivity().supportFragmentManager
            timePickerFragment.show(supportFragmentManager, "TimePikerFragment")
        }


        supportFragmentManager.setFragmentResultListener(
            "REQUEST_KEY1",
            viewLifecycleOwner
        ) {resultKey, bundle ->
            if (resultKey == "REQUEST_KEY1") {
                val time = bundle.getString("SELECTED_DATE1")
                timeText=time.toString()

            }
        }




        //__________передача_______

        binding.btnAdd.setOnClickListener{
            //получаем данные со строк
            val titleText = binding.editTextTextPersonName.text.toString()
            val descriptionText = binding.editTextTextPersonName2.text.toString()


            viewModel.insert(Model(title = titleText, discription = descriptionText, time1 = 4, dataTime=detaText, dataTimeHourMin=timeText)){}
            APP.navController.navigate(R.id.action_addFragment_to_startFragment)
        }
        binding.btnBack.setOnClickListener{
            APP.navController.navigate(R.id.action_addFragment_to_startFragment)
        }





    }

}