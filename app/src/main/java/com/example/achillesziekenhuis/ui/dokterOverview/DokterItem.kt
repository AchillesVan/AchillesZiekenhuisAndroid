package com.example.achillesziekenhuis.ui.dokterOverview

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.achillesziekenhuis.model.Dokter
import com.example.achillesziekenhuis.ui.navigation.DokterOverviewScreen
import com.example.achillesziekenhuis.ui.theme.AchillesZiekenhuisTheme

/**
 * Card to display a doctor
 */
@Composable
fun DokterItem(
    modifier: Modifier = Modifier,
    dokter: Dokter,
    navigate: (String) -> Unit,
) {
    Card(
        modifier = modifier
            .widthIn(0.dp, 128.dp)
            .heightIn(0.dp, 128.dp)
            .padding(4.dp),
        border = BorderStroke(1.dp, Color.Black),
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            AutoFitText(
                text = dokter.voornaam,
                fontWeight = Bold,
            )
            AutoFitText(
                text = dokter.familienaam,
                fontWeight = Bold,
            )
            Spacer(
                modifier = Modifier
                    .weight(1f),
            )
            Text(
                text = dokter.afdeling,
                fontSize = 12.sp,
            )
            Spacer(
                modifier = Modifier
                    .weight(1f),
            )
            Button(
                modifier = Modifier
                    .height(24.dp)
                    .width(96.dp),
                contentPadding = PaddingValues(2.dp),
                onClick = {
                                navigate("${DokterOverviewScreen.Appointment.name}/${dokter.rizivNummer}")
                          },
            ) {
                Text(
                    text = "Maak afspraak",
                    fontSize = 10.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .align(Alignment.CenterVertically),
                )
            }
        }
    }
}

/**
 * Text that automatically fits in the available space
 */
@Composable
fun AutoFitText(
    text: String,
    fontWeight: FontWeight = FontWeight.Normal,
) {
    Text(
        text = text,
        fontWeight = fontWeight,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxWidth(),
        fontSize = LocalDensity.current.run {
            // Calculate the max font size based on the available width
            12.sp.toPx().coerceAtMost((128.dp - 16.dp).toPx())
                .toSp()
        },
        overflow = TextOverflow.Ellipsis,
    )
}

/**
 * Preview for [DokterItem]
 */
@Preview(showBackground = true)
@Composable
fun DokterItemPreview() {
    AchillesZiekenhuisTheme {
        DokterItem(
            dokter = Dokter(
                rizivNummer = "123456789",
                voornaam = "Achilles",
                familienaam = "Vanbelleghem",
                afdeling = "Cardiologie",
                email = "achilles.vanbelleghem@gmail.com",
                telefoonnummer = "0472 12 34 56",
                ),

            navigate = {},
        )
    }
}

/**
 * Preview for [DokterItem] in dark mode
 */
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun DokterItemPreviewDark() {
    AchillesZiekenhuisTheme {
        DokterItem(
            dokter = Dokter(
                rizivNummer = "123456789",
                voornaam = "Achilles",
                familienaam = "Vanbelleghem",
                afdeling = "Cardiologie",
                email = "achilles.vanbelleghem@gmail.com",
                telefoonnummer = "0472 12 34 56",
            ),

            navigate = {},
        )
    }
}
