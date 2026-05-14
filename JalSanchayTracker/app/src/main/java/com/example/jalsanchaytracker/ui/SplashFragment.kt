package com.example.jalsanchaytracker.ui

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.jalsanchaytracker.R
import com.example.jalsanchaytracker.databinding.FragmentSplashBinding
import com.example.jalsanchaytracker.viewmodel.MainViewModel

class SplashFragment : Fragment() {

    private var _binding: FragmentSplashBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSplashBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Handler(Looper.getMainLooper()).postDelayed({
            viewModel.userSetup.observe(viewLifecycleOwner) { setup ->
                if (setup == null) {
                    findNavController().navigate(R.id.action_splashFragment_to_setupFragment)
                } else {
                    findNavController().navigate(R.id.action_splashFragment_to_homeFragment)
                }
            }
        }, 2000)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
