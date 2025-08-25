package com.mavapps.coroutinecraft.presentation.ui.splash

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.mavapps.commonkit.widgets.HeaderText
import com.mavapps.coroutinecraft.presentation.navigation.AI_CHAT
import com.mavapps.coroutinecraft.presentation.navigation.SPLASH
import com.mavapps.coroutinecraft.ui.theme.CoroutineCraftTheme
import kotlinx.coroutines.delay



@Composable
fun SplashScreen( modifier: Modifier ) {
    val navController = rememberNavController()

    LaunchedEffect(Unit) {
        delay(2000)
        navController.navigate(AI_CHAT) {
            popUpTo(SPLASH) { inclusive = true }
        }
    }

    // UI content of splash
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        HeaderText("Coroutine Craft", modifier = Modifier.fillMaxSize())
    }
}

@Preview(showBackground = true)
@Composable
fun MyAppPreview() {
    CoroutineCraftTheme {
       //SplashScreen()
    }
}