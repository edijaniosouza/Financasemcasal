package com.example.financasemcasal.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.financasemcasal.database.repository.UserAccountRepository
import com.example.financasemcasal.model.UserAccount
import kotlinx.coroutines.launch

class UserAccountViewModel(private val repository: UserAccountRepository) : ViewModel() {

    fun newUser(userAccount: UserAccount) {
        viewModelScope.launch {
            repository.createUser(userAccount)
        }
    }
}