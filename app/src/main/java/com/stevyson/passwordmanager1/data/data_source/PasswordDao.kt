package com.stevyson.passwordmanager1.data.data_source

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.stevyson.passwordmanager1.domain.model.Password
import kotlinx.coroutines.flow.Flow


@Dao
interface PasswordDao {
    @Query("SELECT * FROM password")
    fun getPasswords(): Flow<List<Password>>

    @Query("SELECT * FROM password WHERE id = :id")
    suspend fun getPasswordById(id: Int): Password?

    @Upsert
    suspend fun insertPassword(password: Password)

    @Delete
    suspend fun deletePassword(password: Password)


}