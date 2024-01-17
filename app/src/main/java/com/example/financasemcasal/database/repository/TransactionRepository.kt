package com.example.financasemcasal.database.repository

import androidx.lifecycle.LiveData
import com.example.financasemcasal.database.dao.TransactionDao
import com.example.financasemcasal.model.Transaction

class TransactionRepository(
    private val transactionDao: TransactionDao
) {

    fun getAllTransactions(): LiveData<List<Transaction>> {
        return transactionDao.getAllTransactions()
    }

    suspend fun insertTransaction(transaction: Transaction){
        transactionDao.newTransaction(transaction)
    }

    suspend fun deleteTransaction(transaction: Transaction){
        transactionDao.deleteTransaction(transaction)
    }
}