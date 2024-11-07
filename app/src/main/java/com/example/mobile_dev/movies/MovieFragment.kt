package com.example.mobile_dev.movies

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.mobile_dev.R
import com.example.mobile_dev.databinding.MovieFragmentBinding

class SecondFragment : Fragment(R.layout.movie_fragment) {
    private lateinit var binding: MovieFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MovieFragmentBinding.bind(view)
    }
}