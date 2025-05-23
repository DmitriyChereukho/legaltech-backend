package ru.hse.legaltech.backend.model

data class LoginRequest(
    val username: String,
    val password: String,
)