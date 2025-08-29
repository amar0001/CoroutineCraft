package com.mavapps.coroutinecraft.presentation.ui.signup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mavapps.coroutinecraft.data.repository.AuthRepository
import com.mavapps.coroutinecraft.domain.usecase.PasswordsMatchUseCase
import com.mavapps.coroutinecraft.domain.usecase.ValidateEmailUseCase
import com.mavapps.coroutinecraft.domain.usecase.ValidatePasswordUseCase
import com.mavapps.coroutinecraft.domain.usecase.ValidateUsernameUseCase
import com.mavapps.coroutinecraft.presentation.ui.authcommon.ApiUiState
import com.mavapps.coroutinecraft.presentation.ui.authcommon.AuthUiState
import com.mavapps.coroutinecraft.presentation.ui.authcommon.SignUpUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val usernameUseCase: ValidateUsernameUseCase,
    private val validateEmailUseCase: ValidateEmailUseCase,
    private val validatePasswordUseCase: ValidatePasswordUseCase,
    private val passwordsMatchUseCase: PasswordsMatchUseCase,
    private val repository: AuthRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(SignUpUiState())
    val uiState: StateFlow<SignUpUiState> = _uiState

    private val _signUpApiUiState = MutableStateFlow(ApiUiState())
    val signUpApiUiState: StateFlow<ApiUiState> = _signUpApiUiState

    fun onUserNameChanged(username: String) {
        _uiState.value = _uiState.value.copy(username = username)
        resetSignUpUIState()
    }

    fun onEmailChanged(email: String) {
        _uiState.value = _uiState.value.copy(email = email)
        resetSignUpUIState()
    }

    fun onPasswordChanged(password: String) {
        _uiState.value = _uiState.value.copy(password = password)
        resetSignUpUIState()
    }

    fun onConfirmPasswordChanged(confirmPassword: String) {
        _uiState.value = _uiState.value.copy(confirmPassword = confirmPassword)
        resetSignUpUIState()
    }

    fun resetSignUpUIState() {
        _signUpApiUiState.value = _signUpApiUiState.value.copy(
            isLoginSuccess = false,
            isLoading = false,
            errorMessage = null
        )
    }

    fun validateSignUp() {
        val userNameResult = usernameUseCase(_uiState.value.email)
        val emailResult = validateEmailUseCase(_uiState.value.email)
        val passwordResult = validatePasswordUseCase(_uiState.value.password)
        val confirmPasswordResult = passwordsMatchUseCase(_uiState.value.password, _uiState.value.confirmPassword)
        val hasError = listOf(userNameResult, emailResult, passwordResult, confirmPasswordResult).any { !it.successful }
        _uiState.value = _uiState.value.copy(
            emailError = emailResult.errorMessage,
            passwordError = passwordResult.errorMessage,
            confirmPasswordError = confirmPasswordResult.errorMessage,
        )
        if (!hasError) {
            // Proceed with login
            signUpUser(_uiState.value.username, _uiState.value.email, _uiState.value.password)
        }
    }

    fun signUpUser(username : String, email: String, password: String) {
        viewModelScope.launch {
            _signUpApiUiState.value = _signUpApiUiState.value.copy(isLoading = true)

            val result = repository.signUpUser(username, email, password)

            if (result.isSuccess) {
                _signUpApiUiState.value = _signUpApiUiState.value.copy(
                    isLoading = false,
                    isLoginSuccess = true
                )
            } else {
                _signUpApiUiState.value = _signUpApiUiState.value.copy(
                    isLoading = false,
                    errorMessage = result.exceptionOrNull()?.message ?: "Signup failed"
                )
            }
        }
    }



}