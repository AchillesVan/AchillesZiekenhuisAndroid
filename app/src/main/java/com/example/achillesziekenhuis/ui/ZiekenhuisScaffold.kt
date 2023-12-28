package com.example.achillesziekenhuis.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun ZiekenhuisScaffold(
    modifier: Modifier = Modifier,
    topBar: @Composable () -> Unit,
    bottomBar: @Composable () -> Unit,
    content: @Composable (Modifier) -> Unit,
) {
    Scaffold(
        containerColor = Color.Transparent,
        topBar = { topBar() },
        bottomBar = { bottomBar() },
        content = { innerPadding ->
            Column(modifier = modifier.padding(innerPadding)) {
                content(Modifier)
            }
        }
    )
}
