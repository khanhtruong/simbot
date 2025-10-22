package com.example.test.model

sealed class SSEStatus {
    object isLoading : SSEStatus()

    data class success<T>(val data: T) : SSEStatus()

    data class error(val message: String) : SSEStatus()
}
