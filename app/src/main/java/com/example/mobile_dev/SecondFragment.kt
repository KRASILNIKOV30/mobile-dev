package com.example.mobile_dev

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.mobile_dev.databinding.FragmentSecondBinding

class SecondFragment : Fragment(R.layout.fragment_second) {
    private lateinit var binding: FragmentSecondBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentSecondBinding.bind(view)

        val name = arguments?.getString("NAME")

        binding.backButton.setOnClickListener {
            findNavController().popBackStack()
            Log.v("my log", name ?: "")
        }
    }
}