package com.example.achillesziekenhuis.ui.login

import android.content.res.Configuration
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.achillesziekenhuis.ui.theme.AchillesZiekenhuisTheme

/**
 * A button that is used to login.
 *
 * @param onClick the action that is performed when the button is clicked.
 * @param modifier the modifier for this composable.
 *
 * @sample LoginButtonPreview
 * @sample LoginButtonPreviewDark
 */
@Composable
fun LoginButton(onClick: () -> Unit, modifier: Modifier = Modifier) {
    Button(
        onClick = onClick,
        modifier = modifier,
    ) {
        Text(text = "Log in")
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
private fun LoginButtonPreview() {
    AchillesZiekenhuisTheme {
        LoginButton(onClick = {})
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun LoginButtonPreviewDark() = LoginButtonPreview()
