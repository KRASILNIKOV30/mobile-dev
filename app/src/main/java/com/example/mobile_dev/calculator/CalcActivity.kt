package com.example.mobile_dev.calculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mobile_dev.R
import com.example.mobile_dev.databinding.CalculatorBinding

class CalcActivity : AppCompatActivity() {
    private lateinit var binding: CalculatorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = CalculatorBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initEventListeners()
    }

    private fun initEventListeners() {
        binding.button1.setOnClickListener {
            expression += binding.button1.text
        }
        binding.button2.setOnClickListener {
            expression += binding.button2.text
        }
        binding.button3.setOnClickListener {
            expression += binding.button3.text
        }
        binding.button4.setOnClickListener {
            expression += binding.button4.text
        }
        binding.button5.setOnClickListener {
            expression += binding.button5.text
        }
        binding.button6.setOnClickListener {
            expression += binding.button6.text
        }
        binding.button7.setOnClickListener {
            expression += binding.button7.text
        }
        binding.button8.setOnClickListener {
            expression += binding.button8.text
        }
        binding.button9.setOnClickListener {
            expression += binding.button9.text
        }
        binding.button10.setOnClickListener {
            expression += binding.button10.text
        }
        binding.button11.setOnClickListener {
            expression += binding.button11.text
        }
        binding.button12.setOnClickListener {
            expression += binding.button12.text
        }
        binding.button13.setOnClickListener {
            expression += binding.button13.text
        }
        binding.button14.setOnClickListener {
            expression += binding.button14.text
        }
        binding.button15.setOnClickListener {
            expression = expression.dropLast(1)
        }
        binding.button16.setOnClickListener {
            expression += binding.button16.text
        }
    }
}