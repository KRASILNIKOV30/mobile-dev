package com.example.mobile_dev.dataStorage

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface SubjectDao {
    @Query("SELECT * FROM subject")
    suspend fun getAll(): List<Subject>

    @Insert
    suspend fun insertAll(vararg subjects: Subject)

    @Delete
    suspend fun delete(subject: Subject)
}