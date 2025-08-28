package com.mavapps.coroutinecraft.presentation.ui.authcommon

data class ApiUiState(
    val isLoading: Boolean = false,
    val isLoginSuccess: Boolean = false,
    val errorMessage: String? = null
)


