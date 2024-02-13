package com.example.financasemcasal.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.financasemcasal.database.repository.TransactionRepository
import com.example.financasemcasal.model.Transaction
import com.example.financasemcasal.model.TransactionWithUserAccounts
import com.example.financasemcasal.model.UserAccount
import kotlinx.coroutines.launch

class TransactionViewModel(private val repository: TransactionRepository) : ViewModel() {

    private val _allTransactions: LiveData<List<Transaction>> = repository.getAllTransactions()
    val allTransactions: LiveData<List<Transaction>>
        get() = _allTransactions

    private val _allTransactionsUsers: LiveData<List<TransactionWithUserAccounts>> = repository.getTransactionUsers()
    val allTransactionsUsers: LiveData<List<TransactionWithUserAccounts>>
        get() = _allTransactionsUsers
    fun insertTransaction(transaction: Transaction) {
        // Execute a inserção em uma coroutine, se necessário
        // Pode ser ajustado conforme a lógica específica do seu aplicativo
        viewModelScope.launch {
            repository.insertTransaction(transaction)
        }
    }

    fun deleteTransaction(transaction: Transaction){
        viewModelScope.launch {
            repository.deleteTransaction(transaction)
        }
    }

    fun getUser(email:String, password:String) : LiveData<UserAccount>{
        return repository.getUser(email, password)
    }

    fun createLink(transactionId:Long, userId:Long){
        viewModelScope.launch {
            repository.createLink(transactionId, userId)
        }
    }


    fun getTeste(){
        repository.getTransactionUsers()
    }

}