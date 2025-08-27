package com.mavapps.coroutinecraft.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mavapps.coroutinecraft.presentation.ui.changepassword.ChangePasswordScreen
import com.mavapps.coroutinecraft.presentation.ui.forgotpassword.ForgotPasswordScreen
import com.mavapps.coroutinecraft.presentation.ui.home.HomeScreen
import com.mavapps.coroutinecraft.presentation.ui.signin.SignInScreen
import com.mavapps.coroutinecraft.presentation.ui.signup.SignUpScreen
import com.mavapps.coroutinecraft.presentation.ui.splash.SplashScreen

@Composable
fun NavGraph(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(
        navController = navController,
        startDestination = SPLASH // Default after splash
    ) {
        composable(SPLASH) {
            SplashScreen(navController = navController)
        }
        composable(SIGN_IN) {
            SignInScreen(navController = navController, modifier = modifier)
        }
        // Login ke baad yaha navigate karna hoga:
        composable(HOME) {
            HomeScreen(rootNavController = navController, modifier)
        }

        composable(SIGN_UP) {
            SignUpScreen(navController = navController, modifier = modifier)
        }
        composable(FORGOT_PASSWORD) {
            ForgotPasswordScreen(navController = navController, modifier = modifier)
        }
        composable(CHANGE_PASSWORD) {
            ChangePasswordScreen(navController = navController, modifier = modifier)
        }



    }
}


