package com.example.mobile_dev.movies

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mobile_dev.databinding.MoviesMainActivityBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: MoviesMainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MoviesMainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}