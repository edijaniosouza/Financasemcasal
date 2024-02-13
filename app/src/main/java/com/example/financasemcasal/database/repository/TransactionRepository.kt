package com.example.financasemcasal.database.repository

import androidx.lifecycle.LiveData
import com.example.financasemcasal.database.dao.TransactionDao
import com.example.financasemcasal.database.dao.TransactionWithUserAccountsDao
import com.example.financasemcasal.database.dao.UserAccountDao
import com.example.financasemcasal.model.Transaction
import com.example.financasemcasal.model.TransactionUserCrossRef
import com.example.financasemcasal.model.TransactionWithUserAccounts
import com.example.financasemcasal.model.UserAccount

class TransactionRepository(
    private val transactionDao: TransactionDao,
    private val daoTeste: TransactionWithUserAccountsDao,
    private val userDao: UserAccountDao
) {

    fun getAllTransactions(): LiveData<List<Transaction>> {
        return transactionDao.getAllTransactions()
    }

    fun getTransactionUsers(): LiveData<List<TransactionWithUserAccounts>>{
        return daoTeste.getAllTransactionsWithUserAccounts()
    }

    fun getUser(email:String,password:String) : LiveData<UserAccount>{
        return userDao.getUserByEmailAndPassword(email,password)
    }

    suspend fun createLink(transactionId: Long, userId:Long){
        daoTeste.insertTransactionUserCrossRef(
            TransactionUserCrossRef(
                transactionId = transactionId,
                userAccountId = userId,
            )
        )
    }

    suspend fun insertTransaction(transaction: Transaction) {
//        transactionDao.newTransaction(transaction)

        val userTeste = UserAccount(
            userName = "Edijanio",
            userEmail = "teste@teste.com",
            userPassword = "1234"
        )

        daoTeste.insertUserAccount(userTeste)
        daoTeste.insertTransaction(transaction)
    }

    suspend fun deleteTransaction(transaction: Transaction) {
//        transactionDao.deleteTransaction(transaction)
        daoTeste.deleteTransaction(transaction)
    }
}