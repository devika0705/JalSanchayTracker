package com.example.jalsanchaytracker.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.jalsanchaytracker.adapter.Tip
import com.example.jalsanchaytracker.adapter.TipsAdapter
import com.example.jalsanchaytracker.databinding.FragmentTipsBinding

class TipsFragment : Fragment() {

    private var _binding: FragmentTipsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTipsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tips = listOf(
            Tip("Check for Leaks", "A dripping faucet can waste up to 3,000 gallons of water a year. Fix leaks promptly."),
            Tip("Use Rainwater for Gardening", "The water collected from your roof is perfect for plants as it doesn't contain chlorine."),
            Tip("Install a Rain Barrel", "Capture rainwater to use for washing cars, outdoor furniture, or flushing toilets."),
            Tip("Mulch Your Plants", "Applying mulch around plants helps retain moisture and reduces the need for frequent watering."),
            Tip("Water Plants Early", "Water your garden early in the morning or late in the evening to reduce evaporation."),
            Tip("Upgrade Fixtures", "Install low-flow showerheads and aerators on faucets to significantly reduce water usage.")
        )

        val adapter = TipsAdapter(tips)
        binding.recyclerViewTips.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
