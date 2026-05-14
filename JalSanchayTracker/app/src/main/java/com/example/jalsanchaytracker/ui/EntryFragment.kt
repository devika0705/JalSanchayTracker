package com.example.jalsanchaytracker.ui

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.jalsanchaytracker.databinding.FragmentEntryBinding
import com.example.jalsanchaytracker.viewmodel.MainViewModel

class EntryFragment : Fragment() {

    private var _binding: FragmentEntryBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MainViewModel by activityViewModels()

    private var roofArea: Double = 0.0
    private var runoffCoefficient: Double = 0.0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEntryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.userSetup.observe(viewLifecycleOwner) { setup ->
            if (setup != null) {
                roofArea = setup.roofArea
                runoffCoefficient = setup.runoffCoefficient
            }
        }

        binding.etRainfall.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                calculatePreview(s.toString())
            }
            override fun afterTextChanged(s: Editable?) {}
        })

        binding.btnCalculate.setOnClickListener {
            val rainfallStr = binding.etRainfall.text.toString()
            if (rainfallStr.isNotEmpty()) {
                try {
                    val rainfallMM = rainfallStr.toDouble()
                    // Water Saved (Liters) = Area (sq.ft) × Rainfall (mm) × 0.0929 × Runoff Coefficient
                    val litersSaved = roofArea * rainfallMM * 0.0929 * runoffCoefficient
                    val date = System.currentTimeMillis()

                    viewModel.insertRainfall(rainfallMM, litersSaved, date)
                    Toast.makeText(context, "Data saved successfully! Saved ${String.format("%.2f", litersSaved)} L", Toast.LENGTH_LONG).show()
                    binding.etRainfall.text?.clear()
                } catch (e: NumberFormatException) {
                    Toast.makeText(context, "Please enter a valid number", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(context, "Please enter rainfall amount", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun calculatePreview(input: String) {
        if (input.isNotEmpty()) {
            try {
                val rainfall = input.toDouble()
                val liters = roofArea * rainfall * 0.0929 * runoffCoefficient
                binding.tvResult.text = "You can save approximately:\n${String.format("%.2f", liters)} Liters!"
            } catch (e: NumberFormatException) {
                binding.tvResult.text = "Invalid input"
            }
        } else {
            binding.tvResult.text = "Enter rainfall to see how much water you can save today!"
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
