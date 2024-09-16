package com.example.mobile_dev.lab1.diary

class Student(name: String, age: Int, score: Int) {

    override fun toString(): String {
        return "$m_name ($m_age лет) - $m_score балла"
    }

    private val m_name = name
    private val m_age = age
    private val m_score = score
}