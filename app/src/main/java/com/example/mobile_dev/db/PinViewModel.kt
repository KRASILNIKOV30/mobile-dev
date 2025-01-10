package com.example.mobile_dev.db

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

var PIN_LENGTH = 4

enum class PinState  {
    NEW,
    REPEAT,
    ENTER,
}

data class State(
    val pinState: PinState = PinState.NEW,
    val count: Int = 0,
    val isLogin: Boolean = false,
)

sealed interface Event {
    data object IncorrectPin : Event
    data object RepeatFailed : Event
}

class PinViewModel(application: Application) : AndroidViewModel(application) {
    val state = MutableStateFlow(State())
    val event = MutableSharedFlow<Event>()

    private val settingsStorage = SettingsStorage(getApplication<Application>().applicationContext)
    private var pin: String = ""
    private var repeatPin: String = ""
    private var correctPin: String? = null

    fun onCreate() {
        viewModelScope.launch { 
            correctPin = settingsStorage.getPin()
            val pinState: PinState = if (correctPin.isNullOrEmpty()) {
                PinState.NEW
            } else {
                PinState.ENTER
            }
            state.update { it.copy(
                pinState = pinState
            ) }
        }
    }

    fun onInput(value: String) {
        viewModelScope.launch {
            var count: Int
            when (state.value.pinState) {
                PinState.NEW -> {
                    pin += value
                    count = pin.length
                }
                PinState.REPEAT -> {
                    repeatPin += value
                    count = repeatPin.length
                }
                PinState.ENTER -> {
                    pin += value
                    count = pin.length
                }
            }
            state.update { it.copy(
                count = count
            ) }
            if (count == PIN_LENGTH) {
                when (state.value.pinState) {
                    PinState.NEW -> state.update { it.copy(
                        pinState = PinState.REPEAT,
                        count = 0,
                    ) }
                    PinState.REPEAT -> {
                        if (repeatPin == pin) {
                            settingsStorage.savePin(pin)
                            state.update { it.copy(
                                isLogin = true,
                            ) }
                        }
                        else {
                            state.update { it.copy(
                                pinState = PinState.NEW,
                                count = 0,
                            ) }
                            event.emit(Event.RepeatFailed)
                        }
                    }
                    PinState.ENTER -> {
                        if (correctPin == pin) {
                            state.update { it.copy(
                                isLogin = true,
                            ) }
                        }
                        else {
                            state.update { it.copy(
                                count = 0,
                            ) }
                            pin = ""
                            event.emit(Event.IncorrectPin)
                        }
                    }
                }
            }
        }
    }
}