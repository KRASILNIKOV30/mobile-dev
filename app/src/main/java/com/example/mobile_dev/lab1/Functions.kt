package com.example.mobile_dev.lab1
import kotlin.math.pow


operator fun <T> List<T>.component2(): List<T> = this.drop(1)

val sum = { a: Int, b: Int -> a + b }
val subtract = { a: Int, b: Int -> a - b }
val divide = { a: Int, b: Int -> a / b }
val multiply = { a: Int, b: Int -> a * b }
val pow = { a: Int, b: Int -> a.toDouble().pow(b.toDouble()).toInt() }
val max = { params: List<String> -> params.maxOfOrNull { it.toInt() } }
val min = { params: List<String> -> params.minOfOrNull { it.toInt() } }
val sort = { params: List<String> -> params.sorted().joinToString(" < ")}

val handleBinOp = { binOp: (Int, Int) -> Int, params: List<String> ->
    binOp(params[0].toInt(), params[1].toInt()).toString()
}

val makeAboutMessage = { name: String, age: String ->
    "Привет, меня зовут $name, мне $age лет, через 5 лет мне будет ${age.toInt() + 5} лет."
}

val handleCommand = { command: String, params: List<String> ->
    when (command) {
        "sum" -> "Сумма ${params[0]} и ${params[1]} равна ${handleBinOp(sum, params)}"
        "subtract" -> "Разность ${params[0]} и ${params[1]} равна ${handleBinOp(subtract, params)}"
        "divide" -> "Частное ${params[0]} и ${params[1]} равно ${handleBinOp(divide, params)}"
        "multiply" -> "Произведение ${params[0]} и ${params[1]} равно ${handleBinOp(multiply, params)}"
        "pow" -> "${params[0]} в степени ${params[1]} равно ${handleBinOp(pow, params)}"
        "max" -> "Максимум из $params это ${max(params)}"
        "min" -> "Минимум из $params это ${min(params)}"
        "print_list" -> "Отсортированный список $params это ${sort(params)}"
        "print_about" -> makeAboutMessage(params[0], params[1])
        else -> "unknown command"
    }
}

fun main() {
    while (true) {
        println("Ввод")

        val args = readln().split(' ')
        val (command, params) = args

        if (command == "exit") {
            break
        }

        println("Вывод")
        println(handleCommand(command, params))
        println()
    }
}