package com.mavapps.coroutinecraft.presentation.navigation


import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController


@Composable
fun BottomNavigationBar(navController: NavHostController) {
    NavigationBar {
        NavigationBarItem(
            selected = false,
            onClick = { navController.navigate(AI_CHAT) },
            icon = { Icon(Icons.Default.Person, contentDescription = "Chat") },
            label = { Text("Chat") }
        )
        NavigationBarItem(
            selected = false,
            onClick = { navController.navigate(TITLE_HISTORY) },
            icon = { Icon(Icons.Default.AccountBox, contentDescription = "History") },
            label = { Text("History") }
        )
        NavigationBarItem(
            selected = false,
            onClick = { navController.navigate(TITLE_SETTINGS) },
            icon = { Icon(Icons.Default.Settings, contentDescription = "Settings") },
            label = { Text("Settings") }
        )
    }
}

//sealed class BottomBarNavigation(
//    val route: String,
//    val title: String,
//    val icon: ImageVector
//) {
//    object AIChat : BottomBarNavigation(AI_CHAT, AI_CHAT, Icons.Default.Person)
//    object History : BottomBarNavigation(HISTORY, TITLE_HISTORY, Icons.Default.AccountBox)
//    object Settings : BottomBarNavigation(TITLE_SETTINGS, TITLE_SETTINGS, Icons.Default.Settings)
//}
