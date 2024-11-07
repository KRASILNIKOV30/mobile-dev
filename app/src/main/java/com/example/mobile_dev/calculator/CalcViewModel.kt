package com.example.mobile_dev.calculator
import androidx.lifecycle.ViewModel
import com.example.mobile_dev.R

class CalcViewModel: ViewModel() {
    private val calc = Calculator()
    private var expression: String = ""
        set(value) {
            field = value
            binding.expression.text = value
            try {
                result = calc.parse(value).toString()
                binding.result.setTextColor(getColor(R.color.black))
            } catch (_: ArithmeticException) {
                result = getString(R.string.zero_dividing)
                binding.result.setTextColor(getColor(R.color.error))
            } catch (_: Exception) {}
        }
    private var result: String = ""
        set(value) {
            binding.result.text = value
            field = value
        }
}