package com.example.mobile_dev.calculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.mobile_dev.R
import com.example.mobile_dev.databinding.CalculatorBinding
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class CalcActivity : AppCompatActivity() {
    private lateinit var binding: CalculatorBinding

    private val viewModel by lazy {
        ViewModelProvider(this)[CalcViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = CalculatorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.state
            .onEach { render(it) }
            .launchIn(lifecycleScope)

        initEventListeners()
    }

    private fun render(state: State) {
        binding.result.setTextColor(getColor(R.color.black))
        binding.expression.text = state.expression
        binding.result.text = state.result

        if (state.error != null) {
            binding.result.setTextColor(getColor(R.color.error))
            binding.result.text = when (state.error) {
                Error.DIVISION_BY_ZERO -> getString(R.string.zero_dividing)
            }
        }
    }

    private fun initEventListeners() {
        binding.button1.setOnClickListener {
            viewModel.onInput(binding.button1.text.toString())
        }
        binding.button2.setOnClickListener {
            viewModel.onInput(binding.button2.text.toString())
        }
        binding.button3.setOnClickListener {
            viewModel.onInput(binding.button3.text.toString())
        }
        binding.button4.setOnClickListener {
            viewModel.onInput(binding.button4.text.toString())
        }
        binding.button5.setOnClickListener {
            viewModel.onInput(binding.button5.text.toString())
        }
        binding.button6.setOnClickListener {
            viewModel.onInput(binding.button6.text.toString())
        }
        binding.button7.setOnClickListener {
            viewModel.onInput(binding.button7.text.toString())
        }
        binding.button8.setOnClickListener {
            viewModel.onInput(binding.button8.text.toString())
        }
        binding.button9.setOnClickListener {
            viewModel.onInput(binding.button9.text.toString())
        }
        binding.button10.setOnClickListener {
            viewModel.onInput(binding.button10.text.toString())
        }
        binding.button11.setOnClickListener {
            viewModel.onInput(binding.button11.text.toString())
        }
        binding.button12.setOnClickListener {
            viewModel.onInput(binding.button12.text.toString())
        }
        binding.button13.setOnClickListener {
            viewModel.onInput(binding.button13.text.toString())
        }
        binding.button14.setOnClickListener {
            viewModel.onInput(binding.button14.text.toString())
        }
        binding.button15.setOnClickListener {
            viewModel.onInput(null)
        }
        binding.button16.setOnClickListener {
            viewModel.onInput(binding.button16.text.toString())
        }
    }
}