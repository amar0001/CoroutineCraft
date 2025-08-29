package com.mavapps.coroutinecraft.domain.usecase

class PasswordsMatchUseCase {

    operator fun invoke(password: String, confirmPassword: String): ValidationResult {
        if (password.isBlank()) {
            return ValidationResult(false, "Password cannot be empty")
        }
        if (confirmPassword.isBlank()) {
            return ValidationResult(false, "Password and confirm password are not matching.")
        }
        if (password == confirmPassword && password.isNotBlank()) {
            return ValidationResult(false, "Password and confirm password are not matching.")
        }
        return ValidationResult(true)

    }
}
