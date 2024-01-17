package com.example.financasemcasal.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.financasemcasal.model.UserAccount

@Dao
interface UserAccountDao {
    @Insert
    suspend fun newUser(user: UserAccount)
    @Update
    suspend fun editUser(user: UserAccount)
    @Delete
    suspend fun deleteUser(user: UserAccount)

    @Query("SELECT * FROM useraccount WHERE user_account_id = :userId")
    fun getUser(userId: Long): LiveData<UserAccount>

    @Query("SELECT * FROM useraccount WHERE user_email = :email AND user_password = :password")
    fun getUserByEmailAndPassword(email: String, password: String): LiveData<UserAccount>
}