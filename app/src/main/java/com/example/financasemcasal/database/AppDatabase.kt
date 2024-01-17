package com.example.financasemcasal.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.financasemcasal.database.converter.BigDecimalConverter
import com.example.financasemcasal.database.converter.DataConverter
import com.example.financasemcasal.database.dao.TransactionDao
import com.example.financasemcasal.database.dao.UserAccountDao
import com.example.financasemcasal.model.Transaction
import com.example.financasemcasal.model.UserAccount

val DATABASE_NAME = "financas_conjunto_database"

@Database(entities = [Transaction::class, UserAccount::class], version = 5, exportSchema = false)
@TypeConverters(BigDecimalConverter::class, DataConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun transactionDao(): TransactionDao
    abstract fun userAccountDao(): UserAccountDao
}