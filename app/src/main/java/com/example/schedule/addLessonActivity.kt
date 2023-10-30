package com.example.schedule

import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.app.TimePickerDialog
import android.app.TimePickerDialog.OnTimeSetListener
import android.os.Bundle
import android.text.format.DateUtils
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import java.util.Calendar

class addLessonActivity : AppCompatActivity() {
    lateinit var currentDateTime: Button
    var dateAndTime = Calendar.getInstance()
    public override fun onCreate(savedInstance: Bundle?) {
        super.onCreate(savedInstance)
        setContentView(R.layout.activity_add_lesson)

        currentDateTime = findViewById(R.id.time_start)

        currentDateTime.setOnClickListener(View.OnClickListener { v: View? ->
            setTime(
                v
            )
        })
    }

    // отображаем диалоговое окно для выбора времени
    fun setTime(v: View?) {
        TimePickerDialog(
            this@addLessonActivity, t,
            dateAndTime[Calendar.HOUR_OF_DAY],
            dateAndTime[Calendar.MINUTE], true
        )
            .show()
    }

    // установка начальных даты и времени
    private fun setInitialDateTime() {
        currentDateTime!!.text = DateUtils.formatDateTime(
            this,
            dateAndTime.timeInMillis, DateUtils.FORMAT_SHOW_TIME
        )
    }

    // установка обработчика выбора времени
    var t =
        OnTimeSetListener { view, hourOfDay, minute ->
            dateAndTime[Calendar.HOUR_OF_DAY] = hourOfDay
            dateAndTime[Calendar.MINUTE] = minute
            setInitialDateTime()
        }
}