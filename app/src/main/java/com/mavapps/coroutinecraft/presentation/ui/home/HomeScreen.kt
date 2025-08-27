package com.mavapps.coroutinecraft.presentation.ui.home

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mavapps.coroutinecraft.presentation.navigation.AI_CHAT
import com.mavapps.coroutinecraft.presentation.navigation.BottomNavigationBar
import com.mavapps.coroutinecraft.presentation.navigation.TITLE_HISTORY
import com.mavapps.coroutinecraft.presentation.navigation.TITLE_SETTINGS
import com.mavapps.coroutinecraft.presentation.ui.chat.AIChatScreen
import com.mavapps.coroutinecraft.presentation.ui.chathistory.HistoryScreen
import com.mavapps.coroutinecraft.presentation.ui.settings.SettingsScreen

@Composable
fun HomeScreen(rootNavController: NavHostController, modifier: Modifier) {
    val bottomNavController = rememberNavController()

    Scaffold(
    bottomBar = {
        BottomNavigationBar(navController = bottomNavController)
    }
    ) { innerPadding ->
        NavHost(
            navController = bottomNavController,
            startDestination = AI_CHAT,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(AI_CHAT) {
                AIChatScreen(navController = rootNavController, modifier = modifier)
            }
            composable(TITLE_HISTORY) {
                HistoryScreen(navController = rootNavController, modifier = modifier)
            }
            composable(TITLE_SETTINGS) {
                SettingsScreen(navController = rootNavController, modifier = modifier)
            }
        }
    }

}