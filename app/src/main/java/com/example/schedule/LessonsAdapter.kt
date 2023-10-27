package com.example.schedule

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class LessonsAdapter(var lessons: List<Lesson>, var context: Context):
    RecyclerView.Adapter<LessonsAdapter.MyViewHolder>() {
    class MyViewHolder(view: View): RecyclerView.ViewHolder(view){
        val lessonDay: TextView = view.findViewById(R.id.lesson_list_day)
        val lessonTime: TextView = view.findViewById(R.id.lesson_list_time)
        val lessonName: TextView = view.findViewById(R.id.lesson_list_name)
        val lessonTeacherName: TextView = view.findViewById(R.id.lesson_list_teacher_name)
        val lessonClassroom: TextView = view.findViewById(R.id.lesson_list_classroom)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.lesson_in_list, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return lessons.count()
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.lessonClassroom.text = lessons[position].classrom
        holder.lessonTeacherName.text = lessons[position].teachername
        holder.lessonDay.text = lessons[position].day
        holder.lessonName.text = lessons[position].lessonName
        holder.lessonTime.text = lessons[position].timeStart + " - " + lessons[position].timeEnd
    }
}