package com.example.mobile_dev.dataStorage

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mobile_dev.R
import kotlinx.coroutines.runBlocking

@Database(
    entities = [
        Student::class,
        Subject::class,
    ],
    version = 1
)

abstract class AppDatabase : RoomDatabase() {
    abstract fun studentDao(): StudentDao
    abstract fun subjectDao(): SubjectDao
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        runBlocking {
            val dao = StorageApp.db.studentDao()
            val students = dao.getAll()
            println("Students: ${students.joinToString()}")
        }
    }
}