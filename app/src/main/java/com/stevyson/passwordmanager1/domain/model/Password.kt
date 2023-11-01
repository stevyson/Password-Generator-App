package com.stevyson.passwordmanager1.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Password(
    val siteName: String,
    val siteEmail: String,
    val password: String,
    val lastUpdatedAt: Long,
    val category: String,
    @PrimaryKey
    val id: Int? = null
)

class InvalidPasswordException(message: String): Exception(message)
