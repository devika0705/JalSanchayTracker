package com.example.jalsanchaytracker.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.jalsanchaytracker.data.RainfallHistory
import com.example.jalsanchaytracker.databinding.ItemHistoryBinding
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class HistoryAdapter(
    private val onDeleteClick: (RainfallHistory) -> Unit
) : RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {

    private var historyList = emptyList<RainfallHistory>()

    class HistoryViewHolder(val binding: ItemHistoryBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val binding = ItemHistoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HistoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        val currentItem = historyList[position]
        
        val sdf = SimpleDateFormat("MMM dd, yyyy", Locale.getDefault())
        val dateString = sdf.format(Date(currentItem.date))

        holder.binding.tvDate.text = dateString
        holder.binding.tvRainfall.text = "Rainfall: ${String.format("%.2f", currentItem.rainfallMM)} mm"
        holder.binding.tvLitersSaved.text = "Saved: ${String.format("%.2f", currentItem.litersSaved)} L"

        holder.binding.btnDelete.setOnClickListener {
            onDeleteClick(currentItem)
        }
    }

    override fun getItemCount() = historyList.size

    fun setData(history: List<RainfallHistory>) {
        this.historyList = history
        notifyDataSetChanged()
    }
}
