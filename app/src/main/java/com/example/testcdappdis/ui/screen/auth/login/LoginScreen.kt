package com.example.testcdappdis.ui.screen.auth.login

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun LoginContent(modifier: Modifier = Modifier, onNavigateUp: () -> Unit) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Column {
            Text("Login screen")

            Button(
                onClick = onNavigateUp
            ) {
                Text("Back")
            }
        }
    }
}