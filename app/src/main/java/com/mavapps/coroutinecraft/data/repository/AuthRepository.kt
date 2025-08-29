package com.mavapps.coroutinecraft.data.repository

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class AuthRepository {

    private val auth: FirebaseAuth = FirebaseAuth.getInstance()

    suspend fun login(email: String, password: String): Result<FirebaseUser?> {
        return try {
            val result = auth.signInWithEmailAndPassword(email, password).await()
            Result.success(result.user)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun signUpUser(
        username: String,
        email: String,
        password: String
    ): Result<String> {
        return try {
            val authResult = FirebaseAuth.getInstance()
                .createUserWithEmailAndPassword(email, password)
                .await()

            // Get user ID from Firebase
            val uid = authResult.user?.uid

            if (uid != null) {
                val userMap = mapOf(
                    "uid" to uid,
                    "email" to email,
                    "username" to username
                )


                // Save user data in Firestore
                FirebaseFirestore.getInstance()
                    .collection("users")
                    .document(uid)
                    .set(userMap)
                    .await()

                Result.success("User Successfully Created")
            } else {
                Result.failure(Exception("User ID is null"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

}
