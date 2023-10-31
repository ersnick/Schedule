package com.example.schedule

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.util.prefs.PreferencesFactory

class DbHelper(val context: Context, val factory: SQLiteDatabase.CursorFactory?) :
    SQLiteOpenHelper(context, "scheduleDb", factory, 1){
    override fun onCreate(db: SQLiteDatabase?) {
        val query = "CREATE TABLE lessons (id INT PRIMARY KEY, lesName TEXT, teachName TEXT, clasRoom TEXT, typeLess TEXT, numWeek TEXT, day TEXT, timeStart TEXT, timeEnd TEXT)"
        db!!.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS lessons")
        onCreate(db)
    }

    fun addLesson(lesson: Lesson) {
        val values = ContentValues()
        values.put("lesName", lesson.lessonName)
        values.put("teachName", lesson.teacherName)
        values.put("clasRoom", lesson.classroom)
        values.put("typeLess", lesson.lessonType)
        values.put("numWeek", lesson.week)
        values.put("day", lesson.day)
        values.put("timeStart", lesson.timeStart)
        values.put("timeEnd", lesson.timeEnd)

        val db = this.writableDatabase
        db.insert("lessons", null, values)

        db.close()
    }

    fun getLessonFirstWeek(): ArrayList<Lesson>{
        val db = this.readableDatabase
        val lessons = arrayListOf<Lesson>()

        val result = db.rawQuery("SELECT * FROM lessons WHERE numWeek = 'Первая'", null)
        var stat = result.moveToFirst()
        while (stat){
            val ln = result.getString(result.getColumnIndex("lesName"))
            val tn = result.getString(result.getColumnIndex("teachName"))
            val cr = result.getString(result.getColumnIndex("clasRoom"))
            val tl = result.getString(result.getColumnIndex("typeLess"))
            val nw = result.getString(result.getColumnIndex("numWeek"))
            val d = result.getString(result.getColumnIndex("day"))
            val ts = result.getString(result.getColumnIndex("timeStart"))
            val te = result.getString(result.getColumnIndex("timeEnd"))
            lessons.add(Lesson(ln, tn, cr, tl, nw, d, ts, te))
            stat = result.moveToNext()
        }

        return lessons
    }

    fun getLessonSecondWeek(): ArrayList<Lesson> {
        val db = this.readableDatabase
        val lessons = arrayListOf<Lesson>()


        val result = db.rawQuery("SELECT * FROM lessons WHERE numWeek = 'Вторая'", null)
        var stat = result.moveToFirst()
        while (stat){
            val ln = result.getString(result.getColumnIndex("lesName"))
            val tn = result.getString(result.getColumnIndex("teachName"))
            val cr = result.getString(result.getColumnIndex("clasRoom"))
            val tl = result.getString(result.getColumnIndex("typeLess"))
            val nw = result.getString(result.getColumnIndex("numWeek"))
            val d = result.getString(result.getColumnIndex("day"))
            val ts = result.getString(result.getColumnIndex("timeStart"))
            val te = result.getString(result.getColumnIndex("timeEnd"))
            lessons.add(Lesson(ln, tn, cr, tl, nw, d, ts, te))
            stat = result.moveToNext()
        }

        return lessons
    }
}