package com.mavapps.coroutinecraft.presentation.ui.signin

data class LoginUiState(
    val email: String = "",
    val password: String = "",
    val emailError: String? = null,
    val passwordError: String? = null
)