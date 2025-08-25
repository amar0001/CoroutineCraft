package com.mavapps.coroutinecraft

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.mavapps.coroutinecraft.presentation.ui.splash.SplashScreen
import com.mavapps.coroutinecraft.ui.theme.CoroutineCraftTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


        setContent {
            CoroutineCraftTheme {
                Scaffold{ innerPadding ->


                   SplashScreen( modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}


