package com.example.mobile_dev.calculator

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

data class State(
    val expression: String = "",
    val result: String = "",
    val error: Error? = null,
)

enum class Error {
    DIVISION_BY_ZERO,
}

class CalcViewModel : ViewModel() {
    val state = MutableStateFlow(State())
    private val calc = Calculator()

    fun onInput(value: String? = null) {
        val expression = if (value == null) {
            state.value.expression.dropLast(1)
        } else {
            state.value.expression + value
        }

        var error: Error? = null
        val result: String = try {
            calc.parse(expression).toString()
        } catch (_: ArithmeticException) {
            error = Error.DIVISION_BY_ZERO
            state.value.result
        } catch (_: Exception) {state.value.result}

        state.update { it.copy(
            expression = expression,
            result = result,
            error = error,
        ) }
    }
}