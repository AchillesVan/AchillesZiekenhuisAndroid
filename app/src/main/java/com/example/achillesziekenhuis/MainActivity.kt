package com.example.achillesziekenhuis

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.achillesziekenhuis.ui.ZiekenhuisApp
import com.example.achillesziekenhuis.ui.theme.AchillesZiekenhuisTheme

/**
 * Main activity for the app.
 */
class MainActivity : ComponentActivity() {
    /**
     * Create the main activity.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AchillesZiekenhuisTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    ZiekenhuisApp()
                }
            }
        }
    }
}
