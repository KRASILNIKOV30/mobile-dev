package com.example.mobile_dev.movies

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mobile_dev.R
import com.example.mobile_dev.databinding.MoviesListFragmentBinding

class MoviesListFragment : Fragment(R.layout.movies_list_fragment) {
    private lateinit var binding: MoviesListFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MoviesListFragmentBinding.bind(view)
        val adapter = MovieAdapter {
            val arguments = Bundle().apply {
                putString("TITLE", it.title)
                putString("DESCRIPTION", it.description)
                putString("IMAGE_URL", it.imageUrl)
            }

            findNavController()
                .navigate(R.id.action_mainActivity_to_movieFragment, arguments)
        }

        binding.listView.adapter = adapter
        binding.listView.addItemDecoration(Decoration(resources))
        binding.listView.layoutManager = GridLayoutManager(this.context, 2)

        adapter.movieList = Storage.movies
        adapter.notifyDataSetChanged()
    }
}