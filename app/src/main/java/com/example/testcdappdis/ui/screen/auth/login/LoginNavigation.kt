package com.example.testcdappdis.ui.screen.auth.login

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Serializable
data object LoginDestination

fun NavGraphBuilder.loginScreen(
    modifier: Modifier = Modifier,
    onNavigateUp: () -> Unit,
) {
    composable<LoginDestination> {
        LoginContent(
            modifier, onNavigateUp
        )
    }
}