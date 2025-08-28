package com.mavapps.coroutinecraft.domain.usecase

import javax.inject.Inject

// Domain layer (usecase)
//class ChangePasswordUseCase @Inject constructor(
//    private val authRepository: AuthRepository,
//    private val validatePasswordUseCase: ValidatePasswordUseCase
//) {
//    suspend operator fun invoke(oldPassword: String, newPassword: String): ValidationResult {
//        // Validate new password
//        val validation = validatePasswordUseCase(newPassword)
//        if (!validation.successful) return validation
//
//        // Call repository to change password
//        return try {
//            authRepository.changePassword(oldPassword, newPassword)
//            ValidationResult(successful = true)
//        } catch (e: Exception) {
//            ValidationResult(successful = false, errorMessage = e.message ?: "Unknown error")
//        }
//    }
//}
