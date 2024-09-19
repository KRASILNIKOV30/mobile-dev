package com.example.mobile_dev.lab1.diary

operator fun <T> List<T>.component2(): List<T> = this.drop(1)

fun makeIdGenerator(): () -> Id {
    var id = 0
    return { Id(id++.toString()) }
}

val createStudent = { id: Id, params: List<String> ->
    id to Student(id, Name(params[0]), Age(params[1].toInt()), Score(params[2].toInt()))
}

val readStudents = { generateId: () -> Id ->
    readln()
        .split(", ")
        .map { it.split(' ') }
        .associate { createStudent(generateId(), it) }
        .toMutableMap()
}

fun updatePoints(id: Id, score: Score, studentMap: StudentMap) {
    val student = studentMap[id] ?: return
    studentMap[id] = student.copy(score = score)
}

fun rename(id: Id, name: Name, studentMap: StudentMap) {
    val student = studentMap[id] ?: return
    studentMap[id] = student.copy(name = name)
}

typealias StudentMap = MutableMap<Id, Student>

fun main() {
    val generateId = makeIdGenerator()
    val students: StudentMap = readStudents(generateId)

    do {
        val (command, params) = readln().split(' ')
        when (command) {
            "add" -> students += createStudent(generateId(), params)
            "remove" -> students -= Id(params[0])
            "update_points" -> updatePoints(Id(params[0]), Score(params[1].toInt()), students)
            "rename" -> rename(Id(params[0]), Name(params[1]), students)
            "print_sort_by_name" -> students.values
                .sortedBy { it.name.value }
                .forEach { println(it) }

            "print_sort_by_points" -> students.values
                .sortedByDescending { it.score.value }
                .forEach { println(it) }
        }
    } while (command != "exit")
}