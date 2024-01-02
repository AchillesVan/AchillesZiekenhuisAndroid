package com.example.achillesziekenhuis.ui.aboutPage

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.achillesziekenhuis.ui.ZiekenhuisScaffold

/**
 * About page
 */
@Composable
fun AboutPage(
    modifier: Modifier = Modifier,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    goHome: () -> Unit,
    goToAbout: () -> Unit,
    goToLogin: () -> Unit,
) {
    ZiekenhuisScaffold(
        modifier = modifier,
        canNavigateBack = canNavigateBack,
        navigateUp = navigateUp,
        currentScreenTitle = "Over ons ziekenhuis",
        goHome = goHome,
        goToAbout = goToAbout,
        goToLogin = goToLogin,
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Column {
                Row(modifier = Modifier
                    .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Email",
                        modifier = Modifier
                            .fillMaxWidth(),
                        fontWeight = FontWeight.Bold,
                        fontSize = 40.sp,
                        textAlign = TextAlign.Center,
                    )
                }
                Row(modifier = Modifier
                    .fillMaxWidth()
                ) {
                    Text(
                        text = "info.achillesziekenhuis@imaginary.net",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 8.dp),
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center,
                    )
                }
            }
            Column {
                Row(modifier = Modifier
                    .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Telefoon",
                        modifier = Modifier
                            .fillMaxWidth(),
                        fontWeight = FontWeight.Bold,
                        fontSize = 40.sp,
                        textAlign = TextAlign.Center,
                    )
                }
                Row(modifier = Modifier
                    .fillMaxWidth()
                ) {
                    Text(
                        text = "0456 67 89 12",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 8.dp),
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center,
                    )
                }
            }
            Column {
                Row(modifier = Modifier
                    .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Adres",
                        modifier = Modifier
                            .fillMaxWidth(),
                        fontWeight = FontWeight.Bold,
                        fontSize = 40.sp,
                        textAlign = TextAlign.Center,
                    )
                }
                Row(modifier = Modifier
                    .fillMaxWidth()
                ) {
                    Text(
                        text = "Ziekenhuisstraat 1",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 8.dp),
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center,
                    )
                }
                Row(modifier = Modifier
                    .fillMaxWidth()
                ) {
                    Text(
                        text = "8920 Ieper",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 8.dp),
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center,
                    )
                }
                Row(modifier = Modifier
                    .fillMaxWidth()
                ) {
                    Text(
                        text = "Dit zijn fictieve gegevens",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 8.dp),
                        fontSize = 12.sp,
                        textAlign = TextAlign.Center,
                    )
                }
            }

        }
    }
}
