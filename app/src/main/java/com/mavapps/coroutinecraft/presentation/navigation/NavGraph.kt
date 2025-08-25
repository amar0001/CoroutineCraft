package com.mavapps.coroutinecraft.presentation.navigation

import com.mavapps.coroutinecraft.presentation.ui.chat.AIChatScreen
import com.mavapps.coroutinecraft.presentation.ui.chathistory.HistoryScreen
import com.mavapps.coroutinecraft.presentation.ui.settings.SettingsScreen
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomBarNavigation.AIChat.route // Default after splash
    ) {
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

