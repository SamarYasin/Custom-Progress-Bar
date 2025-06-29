package com.example.customprogressbar

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.example.customprogressbar.databinding.ActivityMainBinding
import com.example.customprogressbar.progressBar.ProgressAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val list = listOf(
            R.drawable.image_one,
            R.drawable.image_two,
            R.drawable.image_one,
            R.drawable.image_two,
            R.drawable.image_one,
            R.drawable.image_two,
            R.drawable.image_one,
            R.drawable.image_two
        )

        binding.viewPager.adapter = ViewPagerAdapter(list)

        binding.progressBarRV.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val progressAdapter = ProgressAdapter(list.size)
        binding.progressBarRV.adapter = progressAdapter

        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                progressAdapter.updateProgress(position)
            }
        })

    }
}