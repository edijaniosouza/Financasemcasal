package com.example.financasemcasal.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.financasemcasal.database.dao.TransactionDao
import com.example.financasemcasal.model.Transaction

@Database(entities = [Transaction::class], version = 1, exportSchema = false)
//@TypeConverters(Converter::class)
abstract class AppDatabase : RoomDatabase(){
    abstract fun transactionDao() : TransactionDao
}