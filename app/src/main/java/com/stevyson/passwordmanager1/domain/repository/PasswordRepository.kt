package com.stevyson.passwordmanager1.domain.repository

import com.stevyson.passwordmanager1.domain.model.Password
import kotlinx.coroutines.flow.Flow

interface PasswordRepository {

    fun getPasswords(): Flow<List<Password>>

    suspend fun getPasswordById(id: Int): Password?

    suspend fun insertPassword(password: Password)

    suspend fun deletePassword(password: Password)

}