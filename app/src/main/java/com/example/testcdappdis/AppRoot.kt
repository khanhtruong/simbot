package com.example.testcdappdis

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.testcdappdis.ui.screen.SplashDestination
import com.example.testcdappdis.ui.screen.auth.authScreenRoot
import com.example.testcdappdis.ui.screen.auth.navigateToAuthGraph
import com.example.testcdappdis.ui.screen.main.mainRootScreen
import com.example.testcdappdis.ui.screen.main.navigateToMainGraph
import com.example.testcdappdis.ui.screen.splashScreen

@Composable
fun AppRoot(
    modifier: Modifier = Modifier,
) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = SplashDestination
    ) {
        splashScreen(
            modifier,
            onNavigateToLogin = { navController.navigateToAuthGraph() },
            onNavigateToMain = { navController.navigateToMainGraph() },
        )

        authScreenRoot(
            modifier,
            onNavigateUp = { navController.navigateUp() },
        )

        mainRootScreen(
            modifier,
            onNavigateUp = { navController.navigateUp() },
        )
    }
}