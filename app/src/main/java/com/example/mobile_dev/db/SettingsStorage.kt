package com.example.mobile_dev.db

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.firstOrNull

class SettingsStorage(
    private val context: Context
) {
    private val Context.dataStore by preferencesDataStore(name = "settings")
    private val key = stringPreferencesKey("pin_code_key")

    suspend fun savePin(code: String) {
        context.dataStore.edit {
            it[key] = code
        }
    }

    suspend fun getPin(): String? {
        return context.dataStore.data.firstOrNull()?.get(key)
    }
}