package com.mavapps.coroutinecraft.presentation.navigation

import com.mavapps.coroutinecraft.presentation.ui.chat.AIChatScreen
import com.mavapps.coroutinecraft.presentation.ui.chathistory.HistoryScreen
import com.mavapps.coroutinecraft.presentation.ui.settings.SettingsScreen
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
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

        composable(BottomBarNavigation.AIChat.route) {
            AIChatScreen()
        }
        composable(BottomBarNavigation.History.route) {
            HistoryScreen()
        }
        composable(BottomBarNavigation.Settings.route) {
            SettingsScreen()
        }
    }
}

