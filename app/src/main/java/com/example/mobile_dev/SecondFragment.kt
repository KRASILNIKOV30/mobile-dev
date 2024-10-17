package com.example.mobile_dev

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.mobile_dev.databinding.FragmentSecondBinding

class SecondFragment : Fragment(R.layout.fragment_second) {
    private lateinit var binding: FragmentSecondBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentSecondBinding.bind(view)

        binding.nextButton.setOnClickListener {
            findNavController()
                .navigate(R.id.action_secondFragment_to_thirdFragment, arguments)
        }

        binding.backButton.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}