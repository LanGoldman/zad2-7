package com.example.zad2

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import java.util.*
private const val ARG_DATE = "data"
class DatePickerFragment: DialogFragment()
{
    interface Callbacks{
        abstract val REQUEST_CONTACT: Any?

        fun onDateSelected(date: Date)
    }
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val date = arguments?.getSerializable(ARG_DATE) as Date
        val calendar = Calendar.getInstance()
        calendar.time =date
        val initYear = calendar.get(Calendar.YEAR)
        val initMounth = calendar.get(Calendar.MONTH)
        val initDay =calendar.get(Calendar.DAY_OF_MONTH)

        val dateListener = DatePickerDialog.OnDateSetListener{ _, year, month, dayOfMonth->
            val resultDate = GregorianCalendar(year, month, dayOfMonth).time
            targetFragment?.let { fragment ->
                (fragment as Callbacks).onDateSelected(resultDate)
            }
        }
        return DatePickerDialog(
            requireContext(),
            dateListener,
            initYear,
            initMounth,
            initDay
        )
    }
    companion object{
        fun newInstance(date: Int):
                DatePickerFragment{
            val args = Bundle().apply {
                putSerializable(ARG_DATE,date)
            }
            return DatePickerFragment().apply {
                arguments = args
            }
        }
    }

}