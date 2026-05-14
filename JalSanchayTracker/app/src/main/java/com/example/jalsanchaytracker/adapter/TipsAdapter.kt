package com.example.jalsanchaytracker.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.jalsanchaytracker.databinding.ItemTipBinding

data class Tip(val title: String, val description: String)

class TipsAdapter(private val tipsList: List<Tip>) : RecyclerView.Adapter<TipsAdapter.TipsViewHolder>() {

    class TipsViewHolder(val binding: ItemTipBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TipsViewHolder {
        val binding = ItemTipBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TipsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TipsViewHolder, position: Int) {
        val currentItem = tipsList[position]
        holder.binding.tvTipTitle.text = currentItem.title
        holder.binding.tvTipDescription.text = currentItem.description
    }

    override fun getItemCount() = tipsList.size
}
