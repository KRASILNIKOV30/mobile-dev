package com.example.mobile_dev.cookies
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.mobile_dev.R
import com.example.mobile_dev.databinding.FragmentCookieBinding

class FragmentCookies : Fragment(R.layout.fragment_cookie) {
    private lateinit var binding: FragmentCookieBinding
    private val viewModel by lazy {
        val provider = ViewModelProvider(owner = this)
        provider[CookiesViewModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentCookieBinding.bind(view)

        binding.button.text = "Cookies: ${viewModel.cookiesCount}"

        binding.button.setOnClickListener {
            binding.button.text = "Cookies: ${++viewModel.cookiesCount}"
        }
    }

    init {
        println("Cookies: init")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("Cookies: onCreate")
    }


    override fun onStart() {
        super.onStart()
        println("Cookies: onStart")
    }

    override fun onResume() {
        super.onResume()
        println("Cookies: onResume")
    }

    override fun onPause() {
        super.onPause()
        println("Cookies: onPause")
    }

    override fun onStop() {
        super.onStop()
        println("Cookies: onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        println("Cookies: onDestroyView")
    }
}