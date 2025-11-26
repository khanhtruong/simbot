package com.example.testcdappdis.ui.screen.auth.signup

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Serializable
data object SignUpDestination

fun NavGraphBuilder.signUpScreen(
    modifier: Modifier = Modifier,
    onNavigateUp: () -> Unit,
) {
    composable<SignUpDestination> {
        SignUpContent(
            modifier, onNavigateUp
        )
    }
}