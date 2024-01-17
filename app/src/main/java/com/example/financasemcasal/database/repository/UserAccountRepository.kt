package com.example.financasemcasal.database.repository

import com.example.financasemcasal.database.dao.UserAccountDao
import com.example.financasemcasal.model.UserAccount

class UserAccountRepository(
    private val userAccountDao: UserAccountDao
) {

    suspend fun createUser(user: UserAccount){
        userAccountDao.newUser(user)
    }

    suspend fun deleteUser(user: UserAccount){
        userAccountDao.deleteUser(user)
    }
}