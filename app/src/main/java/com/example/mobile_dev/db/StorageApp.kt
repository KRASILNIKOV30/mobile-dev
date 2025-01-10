package com.example.mobile_dev.db

import android.app.Application
import androidx.room.Room

class StorageApp : Application() {
    override fun onCreate() {
        super.onCreate()

        db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "day-book-storage"
        ).build()
    }

    companion object {
        lateinit var db: AppDatabase
    }
}