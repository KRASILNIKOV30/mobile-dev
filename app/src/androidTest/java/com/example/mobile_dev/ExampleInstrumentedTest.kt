package com.example.mobile_dev

import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun calcTests() {
        val calculator = Calculator()
        val calc = { str: String -> calculator.parse(str) }
        val test = { left: Double, right: Double ->
            assertEquals(left, right, .00001)
        }

        test(calc("5"), 5.0)
    }
}