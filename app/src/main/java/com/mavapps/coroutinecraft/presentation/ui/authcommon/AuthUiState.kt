package com.mavapps.coroutinecraft.presentation.ui.authcommon

data class AuthUiState(
    val email: String = "",
    val password: String = "",
    val emailError: String? = null,
    val passwordError: String? = null
)


