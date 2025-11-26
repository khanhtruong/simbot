package com.example.testcdappdis.ui.screen.auth

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Serializable
data object AuthRootDestination

fun NavGraphBuilder.authScreenRoot(
    modifier: Modifier = Modifier,
    onNavigateUp: () -> Unit,
) {
    composable<AuthRootDestination> {
        AuthScreenRoot(modifier, onNavigateUp)
    }
}

fun NavController.navigateToAuthGraph() {
    navigate(AuthRootDestination) {
        popUpTo<AuthRootDestination> {
            inclusive = true
        }
    }
}