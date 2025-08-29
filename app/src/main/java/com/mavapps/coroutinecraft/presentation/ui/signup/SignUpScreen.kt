package com.mavapps.coroutinecraft.presentation.ui.signup

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.mavapps.commonkit.widgets.ErrorMessage
import com.mavapps.commonkit.widgets.ProgressLoader
import com.mavapps.coroutinecraft.presentation.navigation.SIGN_IN
import com.mavapps.coroutinecraft.presentation.navigation.SIGN_UP

@Composable
fun SignUpScreen(modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    viewModel: SignUpViewModel = hiltViewModel()
) {

    val uiState by viewModel.uiState.collectAsState()
    val signinUiState by viewModel.signUpApiUiState.collectAsState()

    if (signinUiState.isLoading) {
        ProgressLoader()
    } else if (signinUiState.isLoginSuccess) {
        navController.navigate(SIGN_IN) {
            popUpTo(SIGN_UP) { inclusive = true }
        }
    } else {
        signinUiState.errorMessage?.let { ErrorMessage(it) }
    }


    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row {
            Text("Already a member? ")
            Text(
                text = "Sign In",
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.clickable {
                    navController.navigate(SIGN_IN)
                }
            )
        }

        Spacer(modifier = Modifier.height(24.dp))


        OutlinedTextField(
            value = uiState.username,
            onValueChange = { viewModel.onUserNameChanged(it) },
            label = { Text("Username") },
            modifier = Modifier.fillMaxWidth()
        )

        if (uiState.usernameError != null) {
            Text(
                text = uiState.usernameError!!,
                color = Color.Red,
                style = MaterialTheme.typography.bodySmall
            )
        }
        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = uiState.email,
            onValueChange = { viewModel.onEmailChanged(it) },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth()
        )

        if (uiState.emailError != null) {
            Text(
                text = uiState.emailError!!,
                color = Color.Red,
                style = MaterialTheme.typography.bodySmall
            )
        }
        Spacer(modifier = Modifier.height(8.dp))


        OutlinedTextField(
            value = uiState.password,
            onValueChange = { viewModel.onPasswordChanged(it) },
            label = { Text("Password") },
            modifier = Modifier.fillMaxWidth()
        )
        if (uiState.passwordError != null) {
            Text(
                text = uiState.passwordError!!,
                color = Color.Red,
                style = MaterialTheme.typography.bodySmall
            )
        }
        Spacer(modifier = Modifier.height(8.dp))


        OutlinedTextField(
            value = uiState.confirmPassword,
            onValueChange = { viewModel.onConfirmPasswordChanged(it) },
            label = { Text("Confirm Password") },
            modifier = Modifier.fillMaxWidth()
        )

        if (uiState.confirmPasswordError != null) {
            Text(
                text = uiState.confirmPasswordError!!,
                color = Color.Red,
                style = MaterialTheme.typography.bodySmall
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { viewModel.validateSignUp() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Sign Up")
        }
    }
}

