package com.example.financasemcasal.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.financasemcasal.database.converter.BigDecimalConverter
import com.example.financasemcasal.database.converter.DateConverter
import com.example.financasemcasal.database.converter.InstantConverter
import com.example.financasemcasal.database.converter.TimestampConverter
import com.example.financasemcasal.database.dao.TransactionDao
import com.example.financasemcasal.database.dao.TransactionWithUserAccountsDao
import com.example.financasemcasal.database.dao.UserAccountDao
import com.example.financasemcasal.model.Transaction
import com.example.financasemcasal.model.TransactionUserCrossRef
import com.example.financasemcasal.model.UserAccount

val DATABASE_NAME = "financas_conjunto_database"

@Database(entities = [Transaction::class, UserAccount::class, TransactionUserCrossRef::class], version = 13, exportSchema = false)
@TypeConverters(BigDecimalConverter::class, InstantConverter::class, TimestampConverter::class, DateConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun transactionDao(): TransactionDao
    abstract fun userAccountDao(): UserAccountDao
    abstract fun TransactionWithUserAccountsDao(): TransactionWithUserAccountsDao
}