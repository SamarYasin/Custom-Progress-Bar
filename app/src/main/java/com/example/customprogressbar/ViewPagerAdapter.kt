package com.example.customprogressbar

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.customprogressbar.databinding.ItemBinding

class ViewPagerAdapter(
    private val list: List<Int>
) : RecyclerView.Adapter<ViewPagerAdapter.ViewPagerViewHolder>() {

    inner class ViewPagerViewHolder(
        private val binding: ItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(image: Int) {
            binding.imageView.setImageResource(image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
        val binding = ItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewPagerViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
        holder.bind(list[position])
    }

}