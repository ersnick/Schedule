package com.example.schedule

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.schedule.databinding.ActivityMainBinding
import com.example.schedule.databinding.FragmentFirstWeekBinding
import com.example.schedule.databinding.RemoveOrEditDialogBinding


class LessonsAdapter(public var lessons: List<Lesson>, var context: Context):
    RecyclerView.Adapter<LessonsAdapter.MyViewHolder>() {
    //lateinit var binding: RemoveOrEditDialogBinding
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
        holder.lessonClassroom.text = lessons[position].classroom
        holder.lessonTeacherName.text = lessons[position].teacherName
        holder.lessonDay.text = lessons[position].day
        holder.lessonName.text = lessons[position].lessonName + " (" + lessons[position].lessonType + ")"
        holder.lessonTime.text = lessons[position].timeStart + " - " + lessons[position].timeEnd

        holder.itemView.setOnClickListener {
            val dialog = Dialog(context)
            dialog.setContentView(R.layout.remove_or_edit_dialog)
            dialog.show()
            val textDelete: TextView = dialog.findViewById(R.id.delete_lesson)
            val textEdit: TextView = dialog.findViewById(R.id.edit_lesson)

            textDelete.setOnClickListener {
                val db = DbHelper(context, null)
                db.writableDatabase
                db.delLesson(lessons[position])
                dialog.dismiss()

                //Пытаюсь обновить фрагмент
                //supportFragmentManager
                //    .beginTransaction()
                //    .replace(R.id.schedule, FirstWeekFragment.newInstance())
                //    .commit()
            }

            textEdit.setOnClickListener {
                //TODO open edit activity
            }
        }
    }
}