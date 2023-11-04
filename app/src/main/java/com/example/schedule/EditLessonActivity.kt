package com.example.schedule

import android.app.TimePickerDialog
import android.app.TimePickerDialog.OnTimeSetListener
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.format.DateUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import java.util.Calendar

class EditLessonActivity : AppCompatActivity() {
    lateinit var lessonStartTime: Button
    lateinit var lessonEndTime: Button
    var dateAndTime = Calendar.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_lesson)
        val lesson = intent.extras?.get("extra_lesson") as Lesson

        val lessonName: EditText = findViewById(R.id.lesson_name)
        val teacherName: EditText = findViewById(R.id.teacher_name)
        val classroom: EditText = findViewById(R.id.classroom)
        val typeOfLesson: Spinner = findViewById(R.id.type_of_lesson)
        val numberOfWeek: Spinner = findViewById(R.id.number_of_week)
        val dayLesson: Spinner = findViewById(R.id.days)
        lessonStartTime = findViewById(R.id.time_start)
        lessonEndTime = findViewById(R.id.time_end)
        val buttonDone: Button = findViewById(R.id.button_done)

        lessonName.setText(lesson.lessonName)
        teacherName.setText(lesson.teacherName)
        classroom.setText(lesson.classroom)
        if (lesson.lessonType == "Практика")
            typeOfLesson.setSelection(1)
        if (lesson.lessonType == "Лекция")
            typeOfLesson.setSelection(2)
        if (lesson.lessonType == "Лабораторная")
            typeOfLesson.setSelection(3)
        if (lesson.week == "Первая")
            numberOfWeek.setSelection(1)
        if (lesson.week == "Вторая")
            numberOfWeek.setSelection(2)
        if (lesson.week == "Первая и вторая")
            numberOfWeek.setSelection(3)
        if (lesson.day == "Понедельник")
            dayLesson.setSelection(1)
        if (lesson.day == "Вторник")
            dayLesson.setSelection(2)
        if (lesson.day == "Среда")
            dayLesson.setSelection(3)
        if (lesson.day == "Четверг")
            dayLesson.setSelection(4)
        if (lesson.day == "Пятница")
            dayLesson.setSelection(5)
        if (lesson.day == "Суббота")
            dayLesson.setSelection(6)
        if (lesson.day == "Воскресенье")
            dayLesson.setSelection(7)

        lessonStartTime.setText(lesson.timeStart)
        lessonEndTime.setText(lesson.timeEnd)

        buttonDone.setOnClickListener {
            val lesName = lessonName.text.toString().trim()
            val teachName = teacherName.text.toString().trim()
            val clasRoom = classroom.text.toString().trim()
            val typeLess = typeOfLesson.selectedItem.toString().trim()
            val numWeek = numberOfWeek.selectedItem.toString().trim()
            val day = dayLesson.selectedItem.toString().trim()

            val timeStart = lessonStartTime.text.toString().trim()
            val timeEnd = lessonEndTime.text.toString().trim()

            if (lesName == "" || teachName == "" || clasRoom == "" || typeLess == "Выберите тип занятия" || numWeek == "Выберите неделю" || day == "Выберите день недели" || timeStart == "Начало" || timeEnd == "Конец")
                Toast.makeText(this, "Не все поля заполнены!", Toast.LENGTH_LONG).show()
            else{
                val db = DbHelper(this, null)

                if(numWeek == "Первая и вторая"){
                    val lesson = Lesson(lesName, teachName, clasRoom, typeLess, "Первая", day, timeStart, timeEnd)
                    db.addLesson(lesson)
                    val lesson2 = Lesson(lesName, teachName, clasRoom, typeLess, "Вторая", day, timeStart, timeEnd)
                    db.addLesson(lesson2)
                }
                else{
                    val lesson = Lesson(lesName, teachName, clasRoom, typeLess, numWeek, day, timeStart, timeEnd)
                    db.addLesson(lesson)
                }

                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }

        lessonStartTime.setOnClickListener(View.OnClickListener { v: View? ->
            setTime(
                v
            )
        })

        lessonEndTime.setOnClickListener(View.OnClickListener { v: View? ->
            setTime2(
                v
            )
        })
    }

    // отображаем диалоговое окно для выбора времени
    fun setTime(v: View?) {
        TimePickerDialog(
            this@EditLessonActivity, t,
            dateAndTime[Calendar.HOUR_OF_DAY],
            dateAndTime[Calendar.MINUTE], true
        )
            .show()
    }

    // установка начальных даты и времени
    private fun setInitialDateTime() {
        lessonStartTime!!.text = DateUtils.formatDateTime(
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

    fun setTime2(v: View?) {
        TimePickerDialog(
            this@EditLessonActivity, t2,
            dateAndTime[Calendar.HOUR_OF_DAY],
            dateAndTime[Calendar.MINUTE], true
        )
            .show()
    }

    // установка начальных даты и времени
    private fun setInitialDateTime2() {
        lessonEndTime!!.text = DateUtils.formatDateTime(
            this,
            dateAndTime.timeInMillis, DateUtils.FORMAT_SHOW_TIME
        )
    }

    // установка обработчика выбора времени
    var t2 =
        OnTimeSetListener { view, hourOfDay, minute ->
            dateAndTime[Calendar.HOUR_OF_DAY] = hourOfDay
            dateAndTime[Calendar.MINUTE] = minute
            setInitialDateTime2()
        }
}