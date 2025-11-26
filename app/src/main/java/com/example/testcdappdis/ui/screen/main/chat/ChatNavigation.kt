package com.example.testcdappdis.ui.screen.main.chat

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Serializable
data object ChatDestination

fun NavGraphBuilder.chatScreen(
    modifier: Modifier = Modifier,
    onNavigateUp: () -> Unit,
) {
    composable<ChatDestination> {
        ChatContent(modifier, onNavigateUp)
    }
}