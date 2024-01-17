package com.example.financasemcasal.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.financasemcasal.database.repository.TransactionRepository
import com.example.financasemcasal.model.Transaction
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class TransactionViewModel(private val repository: TransactionRepository) : ViewModel() {

    private val _allTransactions: LiveData<List<Transaction>> = repository.getAllTransactions()
    val allTransactions: LiveData<List<Transaction>>
        get() = _allTransactions

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
}