package com.mavapps.coroutinecraft.presentation.ui.signin

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.mavapps.commonkit.widgets.ErrorMessage
import com.mavapps.commonkit.widgets.ProgressLoader
import com.mavapps.coroutinecraft.presentation.navigation.HOME
import com.mavapps.coroutinecraft.presentation.navigation.SIGN_IN
import com.mavapps.coroutinecraft.presentation.navigation.SIGN_UP

@Composable
fun SignInScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier, viewModel: SignInViewModel = hiltViewModel()
) {

    val uiState by viewModel.uiState.collectAsState()
    val loginUiState by viewModel.loginApiUiState.collectAsState()

    if (loginUiState.isLoading) {
        ProgressLoader()
    } else if (loginUiState.isLoginSuccess) {
        navController.navigate(HOME) {
            popUpTo(SIGN_IN) { inclusive = true }
        }
    } else {
        loginUiState.errorMessage?.let { ErrorMessage(it) }
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Google Login
        Button(
            onClick = { /* TODO: Google Sign-In */ },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Login with Google")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Social icons row
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            IconButton(onClick = { /* Facebook */ }) {
                Icon(Icons.Default.AccountCircle, contentDescription = "Facebook")
            }
            IconButton(onClick = { /* Github */ }) {
                Icon(Icons.Default.AccountCircle, contentDescription = "GitHub")
            }
            IconButton(onClick = { /* Twitter */ }) {
                Icon(Icons.Default.AccountCircle, contentDescription = "Twitter")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        Text("OR")

        Spacer(modifier = Modifier.height(16.dp))

        // Email
        // var email by remember { mutableStateOf(uiState.email) }
        OutlinedTextField(
            value = uiState.email,
            onValueChange = { viewModel.onEmailChanged(it) },
            label = { Text("Email") },
            isError = uiState.emailError != null,
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )
        if (uiState.emailError != null) {
            Text(
                text = uiState.emailError!!,
                color = Color.Red,
                style = MaterialTheme.typography.bodySmall
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Password
        // var password by remember { mutableStateOf(uiState.password) }
        OutlinedTextField(
            value = uiState.password,
            onValueChange = { viewModel.onPasswordChanged(it) },
            label = { Text("Password") },
            isError = uiState.passwordError != null,
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            visualTransformation = PasswordVisualTransformation()
        )
        if (uiState.passwordError != null) {
            Text(
                text = uiState.passwordError!!,
                color = Color.Red,
                style = MaterialTheme.typography.bodySmall
            )
        }
        Spacer(modifier = Modifier.height(8.dp))

        // Remember Me
        var remember by remember { mutableStateOf(false) }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(checked = remember, onCheckedChange = { remember = it })
            Text("Remember Password")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Sign In Button
        Button(
            onClick = {

                viewModel.validateLogin()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Sign In")
        }

        if (!loginUiState.isLoginSuccess && loginUiState.errorMessage != null) {
            Text(
                text = loginUiState.errorMessage!!,
                color = Color.Red,
                style = MaterialTheme.typography.bodySmall
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Navigate to SignUp
        Row {
            Text("Not a user? ")
            Text(
                text = "Sign Up",
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.clickable {
                    navController.navigate(SIGN_UP)
                }
            )
        }
    }
}
