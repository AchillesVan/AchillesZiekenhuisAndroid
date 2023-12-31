package com.example.achillesziekenhuis.ui

import androidx.compose.foundation.layout.Spacer
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ZiekenhuisBottomAppBar(
    goHome: () -> Unit,
    goToAbout: () -> Unit,
    logOut: () -> Unit,
) {
    BottomAppBar(
        containerColor = MaterialTheme.colorScheme.primaryContainer,
        contentColor = MaterialTheme.colorScheme.primary,
        actions = {
            IconButton(onClick = goHome) {
                Icon(
                    Icons.Filled.Home,
                    contentDescription = "navigate to home screen",
                )
            }

            IconButton(onClick = goToAbout) {
                Icon(
                    Icons.Filled.Info,
                    contentDescription = "navigate to about screen",
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            IconButton(onClick = logOut) {
                Icon(
                    Icons.Filled.Logout,
                    contentDescription = "log out",
                )
            }
        },
    )
}
