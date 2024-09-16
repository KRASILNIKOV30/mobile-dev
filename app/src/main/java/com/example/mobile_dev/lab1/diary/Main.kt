package com.example.mobile_dev.lab1.diary

fun makeIdGenerator(): () -> Int {
    var id = 0
    return { id++ }
}

fun main() {
    val studentInfos = readln().split(',')
    val generateId = makeIdGenerator()

}