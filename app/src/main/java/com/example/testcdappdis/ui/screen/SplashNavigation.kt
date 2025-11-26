package com.example.testcdappdis.ui.screen

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Serializable
data object SplashDestination

fun NavGraphBuilder.splashScreen(
    modifier: Modifier = Modifier,
    onNavigateToMain: () -> Unit,
    onNavigateToLogin: () -> Unit,
) {
    composable<SplashDestination> {
        SplashContent(
            modifier,
            onNavigateToMain = onNavigateToMain,
            onNavigateToLogin = onNavigateToLogin
        )
    }
}