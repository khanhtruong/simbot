package com.example.testcdappdis.ui.screen.main.profile

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Serializable
data object ProfileDestination

fun NavGraphBuilder.profileScreen(
    modifier: Modifier = Modifier,
    onNavigateUp: () -> Unit,
) {
    composable<ProfileDestination> {
        ProfileContent(
            modifier, onNavigateUp
        )
    }
}