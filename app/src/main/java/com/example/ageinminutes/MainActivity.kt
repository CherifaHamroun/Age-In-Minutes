package com.example.ageinminutes

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnDatePicker.setOnClickListener { view->
            tvAgeInMinutes.setText("")
            tvSelectedDate.setText("")
            clickDatePicker(view)
        }
    }
    fun clickDatePicker(view: View){
        val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)
        DatePickerDialog(this,DatePickerDialog.OnDateSetListener { view, selectedYear, selectedMonth, selectedDay ->
            Toast.makeText(this,"Date Picked successfully",Toast.LENGTH_LONG).show()
            val selectedDate = "$selectedDay/${selectedMonth+1}/$selectedYear"
            tvSelectedDate.setText(selectedDate)
            if (selectedYear<=year ) {
                if (selectedYear == year && (month<selectedMonth || day<selectedDay))Toast.makeText(this,"Pick Your Birth Date",Toast.LENGTH_LONG).show()
                else{
                        val minute : Int = (selectedYear)*525600+(selectedMonth+1)*43200 + selectedDay *1440
                        val ageInMinutes = "$minute"
                        tvAgeInMinutes.setText(ageInMinutes)
                }
            }
            else Toast.makeText(this,"Pick Your Birth Date",Toast.LENGTH_LONG).show()
            val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
            val theDate = sdf.parse(selectedDate)


        }
            ,year
            ,month
            ,day
        ).show()
    }

}