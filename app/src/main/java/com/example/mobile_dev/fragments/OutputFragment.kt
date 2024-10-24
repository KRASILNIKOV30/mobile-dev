package com.example.mobile_dev.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.mobile_dev.R
import com.example.mobile_dev.databinding.FragmentOutputBinding

class OutputFragment : Fragment(R.layout.fragment_output) {
    private lateinit var binding: FragmentOutputBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentOutputBinding.bind(view)

        val name = arguments?.getString("NAME")
        val surname = arguments?.getString("SURNAME")
        val date = arguments?.getString("DATE")

        binding.nameOutput.text = name
        binding.surnameOutput.text = surname
        binding.dateOutput.text = date

        binding.finishButton.setOnClickListener {
            findNavController()
                .navigate(R.id.action_outputFragment_to_firstFragment)
        }
    }
}