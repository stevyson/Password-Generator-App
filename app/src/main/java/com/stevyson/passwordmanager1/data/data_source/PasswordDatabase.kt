package com.stevyson.passwordmanager1.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.stevyson.passwordmanager1.domain.model.Password


@Database(
    entities = [Password::class],
    version = 1
)
abstract class PasswordDatabase: RoomDatabase() {
    abstract val passwordDao: PasswordDao

    companion object {
        const val DATABASE_NAME = "passwords_db"
    }
}