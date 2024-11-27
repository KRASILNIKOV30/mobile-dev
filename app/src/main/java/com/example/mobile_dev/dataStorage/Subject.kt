package com.example.mobile_dev.dataStorage

import androidx.room.Entity
import androidx.room.PrimaryKey

enum class SubjectComplexity {
    EASY,
    NORMAL,
    VETERAN
}

@Entity
data class Subject(
    @PrimaryKey
    val uid: String,
    val name: String,
    val complexity: SubjectComplexity,
)