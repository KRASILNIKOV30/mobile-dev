package com.example.mobile_dev.movies

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.mobile_dev.R
import com.example.mobile_dev.databinding.MovieFragmentBinding

const val name = "1"

class MovieFragment : Fragment(R.layout.movie_fragment) {
    private lateinit var binding: MovieFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MovieFragmentBinding.bind(view)

        val title = arguments?.getString("TITLE")
        val description = arguments?.getString("DESCRIPTION")
        val imageUrl = arguments?.getString("IMAGE_URL")

        binding.title.text = title
        binding.description.text = description

        this.view?.let {
            Glide
                .with(it)
                .load(imageUrl)
                .centerCrop()
                .into(binding.photo)
        }

        binding.backButton.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}