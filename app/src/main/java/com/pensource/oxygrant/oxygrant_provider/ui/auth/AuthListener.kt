package com.pensource.oxygrant.oxygrant_provider.ui.auth

interface AuthListener {
    fun onStarted()
    fun onSuccess()
    fun onFailure(message: String)
}