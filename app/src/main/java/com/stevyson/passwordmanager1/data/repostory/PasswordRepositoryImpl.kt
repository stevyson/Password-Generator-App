package com.stevyson.passwordmanager1.data.repostory

import com.stevyson.passwordmanager1.data.data_source.PasswordDao
import com.stevyson.passwordmanager1.domain.model.Password
import com.stevyson.passwordmanager1.domain.repository.PasswordRepository
import kotlinx.coroutines.flow.Flow

class PasswordRepositoryImpl(
    private val dao: PasswordDao
): PasswordRepository {
    override fun getPasswords(): Flow<List<Password>> {
        return dao.getPasswords()
    }

    override suspend fun getPasswordById(id: Int): Password? {
        return dao.getPasswordById(id)
    }

    override suspend fun insertPassword(password: Password) {
        dao.insertPassword(password)
    }

    override suspend fun deletePassword(password: Password) {
        dao.deletePassword(password)
    }
}