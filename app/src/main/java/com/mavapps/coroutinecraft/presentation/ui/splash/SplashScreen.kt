package com.mavapps.coroutinecraft.presentation.ui.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.mavapps.commonkit.widgets.HeaderText
import com.mavapps.coroutinecraft.R
import com.mavapps.coroutinecraft.presentation.navigation.AI_CHAT
import com.mavapps.coroutinecraft.presentation.navigation.HOME
import com.mavapps.coroutinecraft.presentation.navigation.SIGN_IN
import com.mavapps.coroutinecraft.presentation.navigation.SPLASH
import com.mavapps.coroutinecraft.ui.theme.CoroutineCraftTheme
import kotlinx.coroutines.delay


@Composable
fun SplashScreen(navController: NavController, modifier: Modifier = Modifier) {


    LaunchedEffect(Unit) {
        delay(2000)
        navController.navigate(SIGN_IN) {
            popUpTo(SPLASH) { inclusive = true }
        }
    }

    // UI content of splash
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center


    ) {

        val imageModifier = Modifier
            .size(150.dp)
        Image(
            painter = painterResource(id = R.drawable.ic_launcher),
            contentDescription = stringResource(id = R.string.app_name),
            contentScale = ContentScale.Fit,
            modifier = imageModifier
        )

        HeaderText("Coroutine Craft", modifier = Modifier.wrapContentWidth(),  )
    }
}

@Preview(showBackground = true)
@Composable
fun MyAppPreview() {
    CoroutineCraftTheme {
        val navController = rememberNavController()
        SplashScreen(navController)
    }
}