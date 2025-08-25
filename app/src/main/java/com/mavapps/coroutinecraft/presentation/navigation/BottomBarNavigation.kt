package com.mavapps.coroutinecraft.presentation.navigation


import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Chat
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarNavigation(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object AIChat : BottomBarNavigation("ai_chat", "AI Chat", Icons.Default.Chat)
    object History : BottomBarNavigation("history", "History", Icons.Default.History)
    object Settings : BottomBarNavigation("settings", "Settings", Icons.Default.Settings)
}
