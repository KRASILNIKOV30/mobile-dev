package com.example.mobile_dev

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.mobile_dev.databinding.ActivityMainBinding

class MyActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recycleView.adapter = MovieAdapter()
    }
}

class Movie(
    val title: String,
)

class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view)

class MovieAdapter : RecyclerView.Adapter<MovieViewHolder>() {
    private val movies = listOf(
        Movie("1"),
        Movie("2"),
        Movie("3"),
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_movie, parent, false)

        return MovieViewHolder(view)
    }

    override fun getItemCount(): Int {
        return movies.count()
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val title = holder.itemView.findViewById<TextView>(R.id.title)
        title.text = movies[position].title
    }
}