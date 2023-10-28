package com.example.schedule

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputBinding
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.schedule.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val bChangeWeek: Button = binding.changeWeekButton

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