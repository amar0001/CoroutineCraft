package com.mavapps.coroutinecraft.presentation.ui.chat

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.mavapps.commonkit.widgets.SearchBarCard

@Composable
fun AIChatScreen(modifier: Modifier, navController: NavHostController) {

    Column(modifier = modifier
        .fillMaxSize()
        .background(Color.Black)
        .padding(10.dp)) {
        Box(modifier
            .fillMaxSize()
            .weight(1.0f)
            .background(Color.Blue))
        {

        }
        SearchBarCard(modifier, searchText = "Type here") {

        }
    }

}
