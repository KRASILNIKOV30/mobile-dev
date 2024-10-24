package com.example.mobile_dev.movies

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.mobile_dev.R
import com.example.mobile_dev.databinding.MoviesListFragmentBinding

class FirstFragment : Fragment(R.layout.movies_list_fragment) {
    private lateinit var binding: MoviesListFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MoviesListFragmentBinding.bind(view)
        private val adapter = MovieAdapter {
            val arguments = Bundle().apply {
                putString("TITLE", it.title)
                putString("DESCRIPTION", it.description)
            }

            findNavController()

        }

        /*binding.openNextInputButton.setOnClickListener {
            val arguments = Bundle().apply {
                putString("NAME", binding.nameInput.text.toString())
                putString("SURNAME", binding.surnameInput.text.toString())
            }

            findNavController()
                .navigate(R.id.action_firstFragment_to_dateFragment, arguments)
        }

        MoviesListFragmentBinding.setOnClickListener {
            findNavController()
                .navigate(R.id.action_firstFragment_to_secondFragment)
        }*/
    }
}