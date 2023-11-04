package com.example.schedule

import java.io.Serializable

public class Lesson(public val lessonName: String, val teacherName: String, val classroom: String,
                    val lessonType: String, val week: String, val day: String, val timeStart: String, val timeEnd: String) : Serializable{
}
