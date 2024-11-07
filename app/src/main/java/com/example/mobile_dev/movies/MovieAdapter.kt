package com.example.mobile_dev.movies

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mobile_dev.databinding.MovieItemBinding
import java.util.Locale

class MovieViewHolder(view: View): RecyclerView.ViewHolder(view)

class MovieAdapter(
    private val onItemClick: (Movie) -> Unit
): RecyclerView.Adapter<MovieViewHolder>() {
    var movieList = listOf<Movie>()

    override fun getItemCount(): Int = movieList.count()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = MovieItemBinding.inflate(inflater, parent, false)

        return MovieViewHolder(view.root)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val itemBinding = MovieItemBinding.bind(holder.itemView)
        val movie = movieList[position]

        itemBinding.title.text = movie.title
        itemBinding.rate.text = String.format(Locale.getDefault(), "%.1f", movie.rate)
        itemBinding.description.text = movie.description
        Glide
            .with(holder.itemView)
            .load(movie.imageUrl)
            .centerCrop()
            .into(itemBinding.photo)

        itemBinding.container.setOnClickListener {
            onItemClick(movie)
        }
    }
}