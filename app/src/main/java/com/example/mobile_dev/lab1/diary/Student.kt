package com.example.mobile_dev.lab1.diary

data class Id(val value: String)
data class Name(val value: String)

data class Age(val value: Int)
data class Score(val value: Int)

data class Student(
    val id: Id,
    val name: Name,
    val age: Age,
    val score: Score,
) {

    override fun toString(): String {
        return "${name.value} (${age.value} лет) - ${score.value} балла"
    }
}