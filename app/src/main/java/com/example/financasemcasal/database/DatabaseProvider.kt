package com.example.financasemcasal.database

import android.content.Context
import androidx.room.Room

val DATABASE_NAME = "financas_conjunto_database"
object DatabaseProvider {
    private var database: AppDatabase? = null

    fun getDatabase(context: Context): AppDatabase {
        return database ?: synchronized(this) {
            val instance = Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                DATABASE_NAME
            ).fallbackToDestructiveMigration().build()
            database = instance
            instance
        }
    }
}