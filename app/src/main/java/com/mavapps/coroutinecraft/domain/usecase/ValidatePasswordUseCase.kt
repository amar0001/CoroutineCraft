package com.mavapps.coroutinecraft.domain.usecase


class ValidatePasswordUseCase {
    operator fun invoke(password: String): ValidationResult {
        if (password.length < 6) {
            return ValidationResult(false, "Password must be at least 6 characters")
        }
        return ValidationResult(true)
    }
}
