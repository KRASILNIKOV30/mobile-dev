package com.example.mobile_dev

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.mobile_dev.databinding.FragmentFirstBinding

class FirstFragment : Fragment(R.layout.fragment_first) {
    private lateinit var binding: FragmentFirstBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentFirstBinding.bind(view)

        binding.openSecondFragmentButton.setOnClickListener {
            val arguments = Bundle().apply {
                putString("NAME", "Pikhail Metrovich")
            }

            findNavController()
                .navigate(R.id.action_firstFragment_to_secondFragment, arguments)
        }
    }
}