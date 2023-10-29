package com.stevyson.passwordmanager1.domain.model

sealed class Category(val name: String) {
    object Social : Category("Social")
    object Streaming : Category("Streaming")
    object Wallet : Category("Wallet")
    object Apps : Category("Apps")
}

