package com.example.schedule

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.schedule.databinding.ActivityMainBinding
import com.example.schedule.databinding.FragmentFirstWeekBinding
import androidx.appcompat.app.AppCompatActivity

class FirstWeekFragment : Fragment() {
    lateinit var binding: FragmentFirstWeekBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstWeekBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val lessonList: RecyclerView = binding.lessonWeek1List
        val lessons = arrayListOf<Lesson>()

        lessons.add(Lesson(3, "Фронтенд", "18:20", "21:25", "132", "Практика", "Пятница", "Первая", "Не помню"))
        lessons.add(Lesson(1, "Технологии прикладного программирования", "9:40", "16:30", "132", "Практика", "Суббота", "Первая", "Веригин Н.В."))
        lessons.add(Lesson(2, "Базы данных", "16:45", "17:15", "132б", "Лекция", "Суббота", "Первая", "Барабанщиков"))

        lessonList.layoutManager = LinearLayoutManager(lessonList.context)
        lessonList.adapter = LessonsAdapter(lessons, lessonList.context)
    }

    companion object {

        @JvmStatic fun newInstance() = FirstWeekFragment()
    }
}