package com.example.mobile_dev.cookies
import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Toast
import androidx.core.view.isInvisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mobile_dev.R
import com.example.mobile_dev.databinding.FragmentCookieBinding
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import java.text.SimpleDateFormat

class FragmentCookies : Fragment(R.layout.fragment_cookie) {
    private lateinit var binding: FragmentCookieBinding
    private val viewModel by lazy {
        val provider = ViewModelProvider(owner = this)
        provider[CookiesViewModel::class.java]
    }
    private lateinit var mainHandler: Handler

    private val updateCookies = object : Runnable {
        override fun run() {
            viewModel.onChange()
            mainHandler.postDelayed(this, 1000)
        }
    }

    private lateinit var adapter: ShopItemAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentCookieBinding.bind(view)
        adapter = ShopItemAdapter {
            viewModel.onShopItemClick(it)
        }
        binding.shop.listView.adapter = adapter
        binding.shop.listView.layoutManager = LinearLayoutManager(this.context)

        viewModel.state
            .onEach { render(it) }
            .launchIn(viewLifecycleOwner.lifecycleScope)

        viewModel.event
            .onEach { handleEvents(it) }
            .launchIn(viewLifecycleOwner.lifecycleScope)

        mainHandler = Handler(Looper.getMainLooper())
        mainHandler.post(updateCookies)
        initEventListeners()
    }

    @SuppressLint("SetTextI18n", "NotifyDataSetChanged")
    private fun render(state: State) {
        binding.stats.cookiesCount.text = state.count.toString()
        binding.stats.time.text = getTime(state.time.toLong())
        binding.stats.perSecond.text = state.cookiesPerSecond.toString()
        binding.stats.avgSpeed.text = state.avgSpeed.toString()

        binding.stats.root.isInvisible = !state.isStatsSelected
        binding.shop.root.isInvisible = state.isStatsSelected

        adapter.shopItemList = state.shopItemList
        adapter.notifyDataSetChanged()
    }

    private fun getTime(time: Long): String {
        val sdf = SimpleDateFormat("mm:ss")
        return sdf.format(time * 1000)
    }

    private fun handleEvents(event: Event) {
        when (event) {
            Event.NotEnoughCookies ->
                Toast.makeText(requireContext(), "Недостаточно печенек", Toast.LENGTH_SHORT).show()
            Event.CookieMessage ->
                Toast.makeText(requireContext(), "Пора прикупить что-нибудь новое", Toast.LENGTH_SHORT).show()
        }
    }

    private fun initEventListeners() {
        binding.stats.button.setOnClickListener {
            viewModel.onCookieClick()
        }
        binding.navPanel.setOnItemSelectedListener {
            viewModel.onMenuItemReselected(it)
            return@setOnItemSelectedListener true
        }
    }
}

