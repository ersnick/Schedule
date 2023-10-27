package com.example.schedule

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val lessonList: RecyclerView = findViewById(R.id.lessonsList)
        val lessons = arrayListOf<Lesson>()

        lessons.add(Lesson(3, "Фронтенд", "18:20", "21:25", "132", "Практика", "Пятница", "Первая", "Не помню"))
        lessons.add(Lesson(1, "Технологии прикладного программирования", "9:40", "16:30", "132", "Практика", "Суббота", "Первая", "Веригин Н.В."))
        lessons.add(Lesson(2, "Базы данных", "16:45", "17:15", "132б", "Лекция", "Суббота", "Первая", "Барабанщиков"))

        lessonList.layoutManager = LinearLayoutManager(this)
        lessonList.adapter = LessonsAdapter(lessons, this)
    }
}