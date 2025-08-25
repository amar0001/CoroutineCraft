package com.mavapps.coroutinecraft.presentation.navigation


import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector




sealed class BottomBarNavigation(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object AIChat : BottomBarNavigation(AI_CHAT, AI_CHAT, Icons.Default.Person)
    object History : BottomBarNavigation(HISTORY, TITLE_HISTORY, Icons.Default.AccountBox)
    object Settings : BottomBarNavigation(TITLE_SETTINGS, TITLE_SETTINGS, Icons.Default.Settings)
}
