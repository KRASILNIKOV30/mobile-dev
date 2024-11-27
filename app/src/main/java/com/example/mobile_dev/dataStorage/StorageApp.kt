package com.example.mobile_dev.dataStorage

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase

class StorageApp : Application() {
    override fun onCreate() {
        super.onCreate()

        db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "database-name"
        ).build()
    }

    companion object {
        lateinit var db: AppDatabase
    }
}