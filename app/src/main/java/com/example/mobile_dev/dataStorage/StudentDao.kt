package com.example.mobile_dev.dataStorage

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface StudentDao {
    @Query("SELECT * FROM student")
    suspend fun getAll(): List<Student>

    @Insert
    suspend fun insertAll(vararg students: Student)

    @Update
    suspend fun updateAll(vararg students: Student)

    @Delete
    suspend fun delete(student: Student)
}