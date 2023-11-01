package com.example.schedule

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputBinding
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.schedule.databinding.ActivityMainBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val bChangeWeek: Button = binding.changeWeekButton
        val addLessonButton: FloatingActionButton = findViewById(R.id.addLessonButton)

        addLessonButton.setOnClickListener {
            val intent = Intent(this, addLessonActivity::class.java)
            startActivity(intent)
        }

        binding.changeWeekButton.setOnClickListener {
            if (bChangeWeek.text == "Первая неделя") {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.schedule, SecondWeekFragment.newInstance())
                    .commit()
                bChangeWeek.text = "Вторая неделя"
            }
            else {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.schedule, FirstWeekFragment.newInstance())
                    .commit()
                bChangeWeek.text = "Первая неделя"
            }
        }

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.schedule, FirstWeekFragment.newInstance())
            .commit()
    }
}