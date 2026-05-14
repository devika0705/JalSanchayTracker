package com.example.jalsanchaytracker.ui

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.jalsanchaytracker.databinding.FragmentReportBinding
import com.example.jalsanchaytracker.viewmodel.MainViewModel
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.utils.ColorTemplate

class ReportFragment : Fragment() {

    private var _binding: FragmentReportBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentReportBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.allHistory.observe(viewLifecycleOwner) { historyList ->
            if (historyList.isNotEmpty()) {
                setupBarChart(historyList)
                setupPieChart(historyList)
            }
        }
    }

    private fun setupBarChart(historyList: List<com.example.jalsanchaytracker.data.RainfallHistory>) {
        val entries = ArrayList<BarEntry>()
        // Simple logic: taking top 7 entries to display in BarChart for simplicity
        val displayList = historyList.take(7).reversed()
        
        displayList.forEachIndexed { index, data ->
            entries.add(BarEntry(index.toFloat(), data.litersSaved.toFloat()))
        }

        val dataSet = BarDataSet(entries, "Liters Saved")
        dataSet.colors = ColorTemplate.MATERIAL_COLORS.toList()
        dataSet.valueTextSize = 12f

        val barData = BarData(dataSet)
        binding.barChart.data = barData
        
        val xAxis = binding.barChart.xAxis
        xAxis.position = XAxis.XAxisPosition.BOTTOM
        xAxis.setDrawGridLines(false)
        
        binding.barChart.description.isEnabled = false
        binding.barChart.animateY(1000)
        binding.barChart.invalidate()
    }

    private fun setupPieChart(historyList: List<com.example.jalsanchaytracker.data.RainfallHistory>) {
        val totalRainfall = historyList.sumOf { it.rainfallMM }
        val totalSaved = historyList.sumOf { it.litersSaved }
        
        val entries = ArrayList<PieEntry>()
        entries.add(PieEntry(totalRainfall.toFloat(), "Total Rainfall (mm)"))
        entries.add(PieEntry(totalSaved.toFloat(), "Total Saved (L)"))
        
        val dataSet = PieDataSet(entries, "Water Stats")
        dataSet.colors = ColorTemplate.JOYFUL_COLORS.toList()
        dataSet.valueTextSize = 14f
        dataSet.valueTextColor = Color.WHITE
        
        val pieData = PieData(dataSet)
        binding.pieChart.data = pieData
        
        binding.pieChart.description.isEnabled = false
        binding.pieChart.centerText = "Overview"
        binding.pieChart.animateY(1000)
        binding.pieChart.invalidate()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
