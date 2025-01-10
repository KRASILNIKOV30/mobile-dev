package com.example.mobile_dev.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface DbItemDao {
    @Query("SELECT * FROM dbItem")
    suspend fun getAll(): List<DbItem>

    @Insert
    suspend fun insertAll(vararg dbItems: DbItem)

    @Update
    suspend fun updateAll(vararg dbItems: DbItem)

    @Delete
    suspend fun delete(dbItem: DbItem)
}