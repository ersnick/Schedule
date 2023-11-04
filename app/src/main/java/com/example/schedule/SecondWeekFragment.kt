package com.example.schedule

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.schedule.databinding.FragmentFirstWeekBinding
import com.example.schedule.databinding.FragmentSecondWeekBinding

class SecondWeekFragment : Fragment() {
    lateinit var binding: FragmentSecondWeekBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondWeekBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val lessonList: RecyclerView = binding.lessonWeek2List
        var lessons = arrayListOf<Lesson>()
        val db = DbHelper(requireContext(), null)
        var dbLessons = db.getLessonSecondWeek()

        // FIXME Дальше идет сортировка по дням недели и по времени и на это лучше не смотреть неподготовленным людям
        val lessonsMonday = arrayListOf<Lesson>()
        val lessonsTuesday = arrayListOf<Lesson>()
        val lessonsWednesday = arrayListOf<Lesson>()
        val lessonsThursday = arrayListOf<Lesson>()
        val lessonsFriday = arrayListOf<Lesson>()
        val lessonsSaturday  = arrayListOf<Lesson>()
        val lessonsSunday = arrayListOf<Lesson>()

        for (lesson in dbLessons){
            if(lesson.day == "Понедельник")
                lessonsMonday.add(lesson)
        }
        for (lesson in dbLessons){
            if(lesson.day == "Вторник")
                lessonsTuesday.add(lesson)
        }
        for (lesson in dbLessons){
            if(lesson.day == "Среда")
                lessonsWednesday.add(lesson)
        }
        for (lesson in dbLessons){
            if(lesson.day == "Четверг")
                lessonsThursday.add(lesson)
        }
        for (lesson in dbLessons){
            if(lesson.day == "Пятница")
                lessonsFriday.add(lesson)
        }
        for (lesson in dbLessons){
            if(lesson.day == "Суббота")
                lessonsSaturday.add(lesson)
        }
        for (lesson in dbLessons){
            if(lesson.day == "Воскресенье")
                lessonsSunday.add(lesson)
        }

        // FIXME я серьезно. это пиздец. не смотри
        val arrTime = mutableListOf<Int>()
        val arrTimeClassicSorted = mutableListOf<String>()
        var arrTimeSorted: MutableList<Int>

        //Понедельник
        for (lesson in lessonsMonday){
            val time = lesson.timeStart
            val timeH = time.substringBefore(":")
            val timeM = time.substringAfter(":")
            val timeSInt = timeH.toInt() * 3600 + timeM.toInt() * 60
            arrTime.add(timeSInt)
        }
        arrTimeSorted = arrTime.sorted().toMutableList()
        for(time in arrTimeSorted){
            val timeH = time / 3600
            val timeM = time % 3600 / 60
            var timeStr: String
            if(timeM < 10)
                timeStr = "$timeH:0$timeM"
            else
                timeStr = "$timeH:$timeM"
            arrTimeClassicSorted.add(timeStr)
        }
        for (time in arrTimeClassicSorted) {
            for (lesson in lessonsMonday){
                if(time == lesson.timeStart)
                    lessons.add(lesson)
            }
        }
        arrTime.clear()
        arrTimeClassicSorted.clear()
        arrTimeSorted.clear()

        //Вторник
        for (lesson in lessonsTuesday){
            val time = lesson.timeStart
            val timeH = time.substringBefore(":")
            val timeM = time.substringAfter(":")
            val timeSInt = timeH.toInt() * 3600 + timeM.toInt() * 60
            arrTime.add(timeSInt)
        }
        arrTimeSorted = arrTime.sorted().toMutableList()
        for(time in arrTimeSorted){
            val timeH = time / 3600
            val timeM = time % 3600 / 60
            var timeStr: String
            if(timeM < 10)
                timeStr = "$timeH:0$timeM"
            else
                timeStr = "$timeH:$timeM"
            arrTimeClassicSorted.add(timeStr)
        }
        for (time in arrTimeClassicSorted) {
            for (lesson in lessonsTuesday){
                if(time == lesson.timeStart)
                    lessons.add(lesson)
            }
        }
        arrTime.clear()
        arrTimeClassicSorted.clear()
        arrTimeSorted.clear()

        //Среда
        for (lesson in lessonsWednesday){
            val time = lesson.timeStart
            val timeH = time.substringBefore(":")
            val timeM = time.substringAfter(":")
            val timeSInt = timeH.toInt() * 3600 + timeM.toInt() * 60
            arrTime.add(timeSInt)
        }
        arrTimeSorted = arrTime.sorted().toMutableList()
        for(time in arrTimeSorted){
            val timeH = time / 3600
            val timeM = time % 3600 / 60
            var timeStr: String
            if(timeM < 10)
                timeStr = "$timeH:0$timeM"
            else
                timeStr = "$timeH:$timeM"
            arrTimeClassicSorted.add(timeStr)
        }
        for (time in arrTimeClassicSorted) {
            for (lesson in lessonsWednesday){
                if(time == lesson.timeStart)
                    lessons.add(lesson)
            }
        }
        arrTime.clear()
        arrTimeClassicSorted.clear()
        arrTimeSorted.clear()

        //Четверг
        for (lesson in lessonsThursday){
            val time = lesson.timeStart
            val timeH = time.substringBefore(":")
            val timeM = time.substringAfter(":")
            val timeSInt = timeH.toInt() * 3600 + timeM.toInt() * 60
            arrTime.add(timeSInt)
        }
        arrTimeSorted = arrTime.sorted().toMutableList()
        for(time in arrTimeSorted){
            val timeH = time / 3600
            val timeM = time % 3600 / 60
            var timeStr: String
            if(timeM < 10)
                timeStr = "$timeH:0$timeM"
            else
                timeStr = "$timeH:$timeM"
            arrTimeClassicSorted.add(timeStr)
        }
        for (time in arrTimeClassicSorted) {
            for (lesson in lessonsThursday){
                if(time == lesson.timeStart)
                    lessons.add(lesson)
            }
        }
        arrTime.clear()
        arrTimeClassicSorted.clear()
        arrTimeSorted.clear()

        //Пятница
        for (lesson in lessonsFriday){
            val time = lesson.timeStart
            val timeH = time.substringBefore(":")
            val timeM = time.substringAfter(":")
            val timeSInt = timeH.toInt() * 3600 + timeM.toInt() * 60
            arrTime.add(timeSInt)
        }
        arrTimeSorted = arrTime.sorted().toMutableList()
        for(time in arrTimeSorted){
            val timeH = time / 3600
            val timeM = time % 3600 / 60
            var timeStr: String
            if(timeM < 10)
                timeStr = "$timeH:0$timeM"
            else
                timeStr = "$timeH:$timeM"
            arrTimeClassicSorted.add(timeStr)
        }
        for (time in arrTimeClassicSorted) {
            for (lesson in lessonsFriday){
                if(time == lesson.timeStart)
                    lessons.add(lesson)
            }
        }
        arrTime.clear()
        arrTimeClassicSorted.clear()
        arrTimeSorted.clear()

        //Суббота
        for (lesson in lessonsSaturday){
            val time = lesson.timeStart
            val timeH = time.substringBefore(":")
            val timeM = time.substringAfter(":")
            val timeSInt = timeH.toInt() * 3600 + timeM.toInt() * 60
            arrTime.add(timeSInt)
        }
        arrTimeSorted = arrTime.sorted().toMutableList()
        for(time in arrTimeSorted){
            val timeH = time / 3600
            val timeM = time % 3600 / 60
            var timeStr: String
            if(timeM < 10)
                timeStr = "$timeH:0$timeM"
            else
                timeStr = "$timeH:$timeM"
            arrTimeClassicSorted.add(timeStr)
        }
        for (time in arrTimeClassicSorted) {
            for (lesson in lessonsSaturday){
                if(time == lesson.timeStart)
                    lessons.add(lesson)
            }
        }
        arrTime.clear()
        arrTimeClassicSorted.clear()
        arrTimeSorted.clear()

        //Воскресенье
        for (lesson in lessonsSunday){
            val time = lesson.timeStart
            val timeH = time.substringBefore(":")
            val timeM = time.substringAfter(":")
            val timeSInt = timeH.toInt() * 3600 + timeM.toInt() * 60
            arrTime.add(timeSInt)
        }
        arrTimeSorted = arrTime.sorted().toMutableList()
        for(time in arrTimeSorted){
            val timeH = time / 3600
            val timeM = time % 3600 / 60
            var timeStr: String
            if(timeM < 10)
                timeStr = "$timeH:0$timeM"
            else
                timeStr = "$timeH:$timeM"
            arrTimeClassicSorted.add(timeStr)
        }
        for (time in arrTimeClassicSorted) {
            for (lesson in lessonsSunday){
                if(time == lesson.timeStart)
                    lessons.add(lesson)
            }
        }
        arrTime.clear()
        arrTimeClassicSorted.clear()
        arrTimeSorted.clear()


        lessonList.layoutManager = LinearLayoutManager(lessonList.context)
        lessonList.adapter = LessonsAdapter(lessons, lessonList.context)
    }

    companion object {
        @JvmStatic
        fun newInstance() =SecondWeekFragment()
    }
}