package com.mavapps.coroutinecraft.presentation.ui.splash

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mavapps.coroutinecraft.ui.theme.CoroutineCraftTheme

@Composable
fun MyApp( modifier: Modifier = Modifier) {
    Text(
        text = "Hello World!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun MyAppPreview() {
    CoroutineCraftTheme {
       MyApp()
    }
}