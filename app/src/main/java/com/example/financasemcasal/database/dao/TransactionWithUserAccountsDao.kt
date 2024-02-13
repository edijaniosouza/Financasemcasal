package com.example.financasemcasal.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.example.financasemcasal.model.TransactionUserCrossRef
import com.example.financasemcasal.model.TransactionWithUserAccounts
import com.example.financasemcasal.model.UserAccount
@Dao
interface TransactionWithUserAccountsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTransaction(transaction: com.example.financasemcasal.model.Transaction)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUserAccount(userAccount: UserAccount)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTransactionUserCrossRef(crossRef: TransactionUserCrossRef)

    @Transaction
    @Query("SELECT * FROM transactions WHERE transaction_id = :transactionId")
    suspend fun getTransactionWithUserAccounts(transactionId: Long): TransactionWithUserAccounts?

    @Transaction
    @Query("SELECT * FROM transactions")
    fun getAllTransactionsWithUserAccounts(): LiveData<List<TransactionWithUserAccounts>>

    @Update
    suspend fun updateTransaction(transaction: com.example.financasemcasal.model.Transaction)

    @Update
    suspend fun updateUserAccount(userAccount: UserAccount)

    @Delete
    suspend fun deleteTransaction(transaction: com.example.financasemcasal.model.Transaction)

    @Delete
    suspend fun deleteUserAccount(userAccount: UserAccount)
}