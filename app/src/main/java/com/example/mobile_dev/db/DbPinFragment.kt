package com.example.mobile_dev.db

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.example.mobile_dev.R
import com.example.mobile_dev.databinding.DbPinBinding
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class DbPinFragment : Fragment(R.layout.db_pin) {
    private lateinit var binding: DbPinBinding

    private val viewModel by lazy {
        val provider = ViewModelProvider(owner = this)
        provider[PinViewModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DbPinBinding.bind(view)

        viewModel.state
            .onEach { render(it) }
            .launchIn(viewLifecycleOwner.lifecycleScope)

        viewModel.event
            .onEach { handleEvents(it) }
            .launchIn(viewLifecycleOwner.lifecycleScope)

        viewModel.onCreate()

        initEventListeners()
    }

    private fun render(state: State) {
        binding.title.text = when (state.pinState) {
            PinState.NEW -> "Придумайте PIN-код"
            PinState.REPEAT -> "Повторите PIN-код"
            PinState.ENTER -> "Введите PIN-код"
        }
        binding.pin1.background.setTint(Color.GRAY)
        binding.pin2.background.setTint(Color.GRAY)
        binding.pin3.background.setTint(Color.GRAY)
        binding.pin4.background.setTint(Color.GRAY)
        if (state.count >= 1) binding.pin1.background.setTint(Color.BLACK)
        if (state.count >= 2) binding.pin2.background.setTint(Color.BLACK)
        if (state.count >= 3) binding.pin3.background.setTint(Color.BLACK)
        if (state.count >= 4) binding.pin4.background.setTint(Color.BLACK)

        if (state.isLogin) {
            val navOptions = NavOptions.Builder()
                .setPopUpTo(R.id.dbPinFragment, false)
                .build()
            findNavController()
                .navigate(R.id.action_dbPinFragment_to_dbListFragment, null, navOptions)
        }
    }

    private fun handleEvents(event: Event) {
        when (event) {
            Event.IncorrectPin ->
                Toast.makeText(requireContext(), "Неверный PIN-код", Toast.LENGTH_SHORT).show()
            Event.RepeatFailed ->
                Toast.makeText(requireContext(), "Коды не совпадают", Toast.LENGTH_SHORT).show()
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
        binding.button0.setOnClickListener {
            viewModel.onInput(binding.button0.text.toString())
        }
    }
}