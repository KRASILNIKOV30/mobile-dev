package com.example.mobile_dev.db

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mobile_dev.databinding.DbActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: DbActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DbActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}