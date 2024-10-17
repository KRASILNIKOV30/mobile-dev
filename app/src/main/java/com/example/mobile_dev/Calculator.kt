package com.example.mobile_dev

import kotlin.math.pow

class Calculator {
    private var pos: Int = -1
    private var ch: Int = 0
    private var str: String = ""

    fun parse(expr: String): Double {
        str = expr.replace(',', '.')
        pos = -1
        ch = 0
        nextChar()
        val x = parseExpression()
        if (pos < str.length) throw RuntimeException("Unexpected: " + ch.toChar())
        return x
    }

    private fun nextChar() {
        ch = if ((++pos < str.length)) str[pos].code else -1
    }

    private fun eat(charToEat: Int): Boolean {
        if (ch == charToEat) {
            nextChar()
            return true
        }
        return false
    }

    private fun parseExpression(): Double {
        var x = parseTerm()
        while (true) {
            if (eat('+'.code)) x += parseTerm() // addition
            else if (eat('-'.code)) x -= parseTerm() // subtraction
            else return x
        }
    }

    private fun parseTerm(): Double {
        var x = parseFactor()
        while (true) {
            if (eat('×'.code)) x *= parseFactor()
            else if (eat('÷'.code)) {
                val factor = parseFactor()
                if (factor == 0.0) {
                    throw ArithmeticException()
                }
                x /= factor
            }
            else return x
        }
    }

    private fun parseFactor(): Double {
        if (eat('+'.code)) return +parseFactor() // unary plus
        if (eat('-'.code)) return -parseFactor() // unary minus

        var x: Double
        val startPos = this.pos
        if (eat('('.code)) { // parentheses
            x = parseExpression()
            if (!eat(')'.code)) throw RuntimeException("Missing ')'")
        } else if ((ch >= '0'.code && ch <= '9'.code) || ch == '.'.code) { // numbers
            while ((ch >= '0'.code && ch <= '9'.code) || ch == '.'.code) nextChar()
            x = str.substring(startPos, this.pos).toDouble()
        } else {
            throw RuntimeException("Unexpected: " + ch.toChar())
        }

        if (eat('^'.code)) x = x.pow(parseFactor()) // exponentiation

        return x
    }
}