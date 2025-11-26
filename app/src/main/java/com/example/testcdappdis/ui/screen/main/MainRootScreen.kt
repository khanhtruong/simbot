package com.example.testcdappdis.ui.screen.main

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.testcdappdis.ui.screen.main.chat.ChatDestination
import com.example.testcdappdis.ui.screen.main.chat.chatScreen
import com.example.testcdappdis.ui.screen.main.profile.profileScreen

@Composable
fun MainRootScreen(modifier: Modifier = Modifier, onNavigateUp: () -> Unit) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = ChatDestination,
    ) {
        chatScreen(modifier, onNavigateUp)

        profileScreen(modifier, onNavigateUp)
    }
}