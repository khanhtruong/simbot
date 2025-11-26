package com.example.testcdappdis.ui.screen.main

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Serializable
data object MainRootDestination

fun NavGraphBuilder.mainRootScreen(
    modifier: Modifier = Modifier,
    onNavigateUp: () -> Unit,
) {
    composable<MainRootDestination> {
        MainRootScreen(
            modifier, onNavigateUp
        )
    }
}

fun NavController.navigateToMainGraph() {
    navigate(MainRootDestination) {
        popUpTo<MainRootDestination> {
            inclusive = true
        }
    }
}