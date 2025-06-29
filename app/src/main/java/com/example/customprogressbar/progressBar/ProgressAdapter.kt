package com.example.customprogressbar.progressBar

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.customprogressbar.R

class ProgressAdapter(
    private val itemsCount: Int,
) : RecyclerView.Adapter<ProgressAdapter.ProgressViewHolder>() {

    private var currentPosition: Int = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProgressViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_progress, parent, false)
        return ProgressViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProgressViewHolder, position: Int) {
        if (position == currentPosition) {
            holder.imageView.setImageResource(R.drawable.rectangle)
        } else {
            holder.imageView.setImageResource(R.drawable.circle)
        }
    }

    override fun getItemCount(): Int = itemsCount

    fun updateProgress(position: Int) {
        currentPosition = position
        notifyDataSetChanged()
    }

    class ProgressViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.progress_icon)
    }

}