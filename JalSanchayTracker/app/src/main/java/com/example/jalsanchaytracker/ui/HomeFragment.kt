package com.example.jalsanchaytracker.ui

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.DecelerateInterpolator
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.jalsanchaytracker.R
import com.example.jalsanchaytracker.databinding.FragmentHomeBinding
import com.example.jalsanchaytracker.viewmodel.MainViewModel

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MainViewModel by activityViewModels()
    
    private var tankCapacity: Double = 1.0 // Prevent division by zero

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupClickListeners()

        viewModel.userSetup.observe(viewLifecycleOwner) { setup ->
            if (setup != null) {
                tankCapacity = setup.tankCapacity
            }
        }

        viewModel.totalLitersSaved.observe(viewLifecycleOwner) { total ->
            val totalSaved = total ?: 0.0
            binding.tvLitersSaved.text = "${String.format("%.2f", totalSaved)} Liters Saved"
            
            val percentage = if (tankCapacity > 0) (totalSaved / tankCapacity) * 100 else 0.0
            val cappedPercentage = percentage.coerceAtMost(100.0).toInt()
            
            binding.tvTankPercentage.text = "$cappedPercentage%"
            animateProgressBar(cappedPercentage)
        }
    }

    private fun animateProgressBar(progressTo: Int) {
        val animation = ObjectAnimator.ofInt(binding.progressTank, "progress", binding.progressTank.progress, progressTo)
        animation.duration = 1500
        animation.interpolator = DecelerateInterpolator()
        animation.start()
    }

    private fun setupClickListeners() {
        binding.cardAddRainfall.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_entryFragment)
        }
        binding.cardHistory.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_historyFragment)
        }
        binding.cardReport.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_reportFragment)
        }
        binding.cardTips.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_tipsFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
