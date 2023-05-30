package com.example.alp_lesswaste.model.user

data class UserState(
    val username: String = "",
    val password: String = "",
    val status: String = "",
    val isLoading: Boolean = false
)

