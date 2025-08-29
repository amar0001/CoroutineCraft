package com.mavapps.coroutinecraft.domain.usecase

class PasswordsMatchUseCase {

    operator fun invoke(password: String, confirmPassword: String): ValidationResult {
        if (confirmPassword.isBlank()) {
            return ValidationResult(false, "Confirm password cannot be empty")
        }

        if (password != confirmPassword) {
            return ValidationResult(false, "Password and confirm password are not matching.")
        }
        return ValidationResult(true)

    }
}
