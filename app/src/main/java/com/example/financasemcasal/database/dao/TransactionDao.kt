package com.example.financasemcasal.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.financasemcasal.model.Transaction

@Dao
interface TransactionDao {
    @Insert
    suspend fun newTransaction(transaction: Transaction)
    @Query("SELECT * FROM transactions")
    fun getAllTransactions() : LiveData<List<Transaction>>
    @Update
    suspend fun editTransaction(transaction: Transaction)
    @Delete
    suspend fun deleteTransaction(transaction: Transaction)
}