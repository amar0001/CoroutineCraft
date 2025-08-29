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
            SignInScreen(modifier = modifier, navController = navController)
        }
        // Login ke baad yaha navigate karna hoga:
        composable(HOME) {
            HomeScreen( modifier = modifier, rootNavController = navController)
        }

        composable(SIGN_UP) {
            SignUpScreen(modifier = modifier, navController = navController)
        }
        composable(FORGOT_PASSWORD) {
            ForgotPasswordScreen( modifier = modifier, navController = navController)
        }
        composable(CHANGE_PASSWORD) {
            ChangePasswordScreen( modifier = modifier, navController = navController)
        }


    }
}


