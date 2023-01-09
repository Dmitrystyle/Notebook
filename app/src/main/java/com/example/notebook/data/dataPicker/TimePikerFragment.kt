package com.example.notebook.data.dataPicker

import android.app.DatePickerDialog
import android.app.Dialog
import android.app.TimePickerDialog
import android.content.Context
import android.os.Bundle
import android.widget.DatePicker
import android.widget.TimePicker
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.setFragmentResult
import java.text.SimpleDateFormat
import java.util.*
import java.util.Calendar.HOUR_OF_DAY
import java.util.Calendar.MINUTE


class TimePikerFragment : DialogFragment(), TimePickerDialog.OnTimeSetListener {
       private val cal = Calendar.getInstance()


       override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

            val hour = cal.get(Calendar.HOUR_OF_DAY)
            val min = cal.get(Calendar.MINUTE)


            return TimePickerDialog(requireActivity(), this, hour, min, true)
        }

    override fun onTimeSet(view: TimePicker?, hour: Int, min: Int) {

        cal.set(Calendar.HOUR_OF_DAY, hour)
        cal.set(Calendar.MINUTE, min)


        val selectedTime = SimpleDateFormat("HH:mm").format(cal.time)

        val selectedTimeBundle = Bundle()
        selectedTimeBundle.putString("SELECTED_DATE1", selectedTime)

        setFragmentResult("REQUEST_KEY1", selectedTimeBundle)


    }

}




