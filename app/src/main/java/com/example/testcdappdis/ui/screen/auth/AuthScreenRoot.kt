package com.example.testcdappdis.ui.screen.auth

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.testcdappdis.ui.screen.auth.login.LoginDestination
import com.example.testcdappdis.ui.screen.auth.login.loginScreen
import com.example.testcdappdis.ui.screen.auth.signup.signUpScreen

@Composable
fun AuthScreenRoot(
    modifier: Modifier = Modifier,
    onNavigateUp: () -> Unit,
) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = LoginDestination
    ) {
        loginScreen(modifier, onNavigateUp)

        signUpScreen(modifier, onNavigateUp)
    }
}