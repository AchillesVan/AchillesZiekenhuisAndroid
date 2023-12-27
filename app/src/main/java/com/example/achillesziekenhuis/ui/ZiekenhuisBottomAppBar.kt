package com.example.achillesziekenhuis.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun ZiekenhuisBottomAppBar(
    goHome: () -> Unit,
    goToAbout: () -> Unit,
) {
    BottomAppBar(
        containerColor = MaterialTheme.colorScheme.primaryContainer,
        contentColor = MaterialTheme.colorScheme.primary,
        actions = {
            IconButton(onClick = goHome) {
                Icon(
                    Icons.Filled.Check,
                    contentDescription = "navigate to home screen",
                )
            }

            IconButton(onClick = goToAbout) {
                Icon(
                    Icons.Filled.Info,
                    contentDescription = "navigate to about screen",
                )
            }
        },
    )
}
