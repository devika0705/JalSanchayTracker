package com.example.jalsanchaytracker.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.jalsanchaytracker.R
import com.example.jalsanchaytracker.databinding.FragmentSetupBinding
import com.example.jalsanchaytracker.viewmodel.MainViewModel

class SetupFragment : Fragment() {

    private var _binding: FragmentSetupBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSetupBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.userSetup.observe(viewLifecycleOwner) { setup ->
            if (setup != null) {
                binding.etRoofArea.setText(setup.roofArea.toString())
                binding.etTankCapacity.setText(setup.tankCapacity.toString())
                binding.etRunoffCoefficient.setText(setup.runoffCoefficient.toString())
            }
        }

        binding.btnSave.setOnClickListener {
            val areaStr = binding.etRoofArea.text.toString()
            val capacityStr = binding.etTankCapacity.text.toString()
            val coefficientStr = binding.etRunoffCoefficient.text.toString()

            if (areaStr.isNotEmpty() && capacityStr.isNotEmpty() && coefficientStr.isNotEmpty()) {
                try {
                    val area = areaStr.toDouble()
                    val capacity = capacityStr.toDouble()
                    val coefficient = coefficientStr.toDouble()

                    viewModel.saveSetup(area, capacity, coefficient)
                    Toast.makeText(context, "Setup saved successfully!", Toast.LENGTH_SHORT).show()
                    findNavController().navigate(R.id.action_setupFragment_to_homeFragment)
                } catch (e: NumberFormatException) {
                    Toast.makeText(context, "Please enter valid numbers", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(context, "Please fill all fields", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnReset.setOnClickListener {
            binding.etRoofArea.text?.clear()
            binding.etTankCapacity.text?.clear()
            binding.etRunoffCoefficient.text?.clear()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
