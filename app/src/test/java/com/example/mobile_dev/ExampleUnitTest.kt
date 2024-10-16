package com.example.mobile_dev

import org.junit.Test
import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    private val calculator = Calculator()
    val calc = { str: String -> calculator.parse(str) }
    val test = { left: Double, right: Double ->
        assertEquals(left, right, .00001)
    }

    @Test
    fun calcTests() {
        test(calc("5"), 5.0)
        test(calc("-5"), (-5.0))
        test(calc("+5"), 5.0)
        test(calc("--5"), 5.0)
        test(calc("++5"), 5.0)

        test(calc("10-8"), 2.0)
        test(calc("-10+8"), -2.0)
        test(calc("10×8"), 80.0)
        test(calc("10÷8"), 1.25)

        test(calc("11÷5.5"), 2.0)
        test(calc("100+5×4-60÷3"), 100.0)

        test(calc("100×5-500+5÷3,2"), 1.5625)
    }
}