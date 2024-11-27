package com.example.mobile_dev.coroutinesExample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobile_dev.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.random.Random

object WeatherApi {
    suspend fun getTemp(): Int {
        return withContext(Dispatchers.IO) {
            Thread.sleep(2000)
            Random.nextInt(-35, 50)
        }
    }

    suspend fun getPrec() {

    }
}

class WeatherViewModel: ViewModel() {
    fun onReloadWeather() {
        viewModelScope.launch {
            val temp = WeatherApi.getTemp()
            val prec = WeatherApi.getPrec()
        }
    }
}

class MainActivity: AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: WeatherViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}

