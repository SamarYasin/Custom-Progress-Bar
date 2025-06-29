package com.example.customprogressbar.progressBar

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.customprogressbar.databinding.CustomProgressBarBinding

class CustomProgressBar @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : FrameLayout(context, attrs, defStyle) {

    private val recyclerView: RecyclerView

    init {
        val binding = CustomProgressBarBinding.inflate(LayoutInflater.from(context), this, true)
        recyclerView = binding.progreessBar
        recyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
    }

    fun setProgress(itemsCount: Int) {
        recyclerView.adapter = ProgressAdapter(itemsCount)
    }

}