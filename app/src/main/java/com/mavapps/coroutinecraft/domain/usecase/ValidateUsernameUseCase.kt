package com.mavapps.coroutinecraft.domain.usecase

class ValidateUsernameUseCase {

    operator fun invoke(username: String): ValidationResult {

            if (username.isBlank()) {
                return ValidationResult(false, "Username cannot be empty.")
            }
            if (username.length < 3) {
                return ValidationResult(false, "username must be at least 3 letters long.")
            }
            return ValidationResult(true)
        }



}
