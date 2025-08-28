package com.mavapps.coroutinecraft.presentation.ui.signin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mavapps.coroutinecraft.data.repository.AuthRepository
import com.mavapps.coroutinecraft.domain.usecase.ValidateEmailUseCase
import com.mavapps.coroutinecraft.domain.usecase.ValidatePasswordUseCase
import com.mavapps.coroutinecraft.presentation.ui.authcommon.ApiUiState
import com.mavapps.coroutinecraft.presentation.ui.authcommon.AuthUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val validateEmailUseCase: ValidateEmailUseCase,
    private val validatePasswordUseCase: ValidatePasswordUseCase,
    private val repository: AuthRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(AuthUiState())
    val uiState = _uiState.asStateFlow()

    private val _loginApiUiState = MutableStateFlow(ApiUiState())
    val loginApiUiState: StateFlow<ApiUiState> = _loginApiUiState

    fun onEmailChanged(email: String) {
        _uiState.value = _uiState.value.copy(email = email, emailError = null)
        resetLoginUIState()
    }

    fun onPasswordChanged(password: String) {
        _uiState.value = _uiState.value.copy(password = password, passwordError = null)
        resetLoginUIState()
    }

    fun resetLoginUIState() {
        _loginApiUiState.value = _loginApiUiState.value.copy(isLoginSuccess = false, isLoading = false, errorMessage = null)
    }

    fun validateLogin() {
        val emailResult = validateEmailUseCase(_uiState.value.email)
        val passwordResult = validatePasswordUseCase(_uiState.value.password)
        val hasError = listOf(emailResult, passwordResult).any { !it.successful }
        _uiState.value = _uiState.value.copy(
            emailError = emailResult.errorMessage,
            passwordError = passwordResult.errorMessage
        )
        if (!hasError) {
            // Proceed with login
            loginUser(_uiState.value.email, _uiState.value.password)
        }
    }

    fun loginUser(email: String, password: String) {
        viewModelScope.launch {
            _loginApiUiState.value = _loginApiUiState.value.copy(isLoading = true)

            val result = repository.login(email, password)

            if (result.isSuccess) {
                _loginApiUiState.value = _loginApiUiState.value.copy(
                    isLoading = false,
                    isLoginSuccess = true
                )
            } else {
                _loginApiUiState.value = _loginApiUiState.value.copy(
                    isLoading = false,
                    errorMessage = result.exceptionOrNull()?.message ?: "Login failed"
                )
            }
        }
    }
}