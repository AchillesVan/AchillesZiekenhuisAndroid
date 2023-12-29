package com.example.achillesziekenhuis.ui.afspraakOverview

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.achillesziekenhuis.ui.theme.AchillesZiekenhuisTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ZiekenhuisDropDown(
    modifier: Modifier = Modifier,
    items: List<String>,
    defaultText: String,
    setSelected: (String) -> Unit,
) {
    var expanded by remember { mutableStateOf(false) }

    var selectedText by remember { mutableStateOf(defaultText) }

    Box (
        modifier = modifier
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = { expanded = !expanded }
        ) {
            TextField(
                value = selectedText,
                onValueChange = {},
                readOnly = true,
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                modifier = Modifier.menuAnchor()
            )

            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                DropdownMenuItem(
                    text = { Text(text = defaultText) },
                    onClick = {
                        selectedText = defaultText
                        setSelected(defaultText)
                        expanded = false
                    }
                )
                items.forEach { label ->
                    DropdownMenuItem(
                        onClick = {
                            selectedText = label
                            setSelected(label)
                            expanded = false
                        },
                        text = { Text(text = label) }
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun ZiekenhuisDropDownPreview() {
    AchillesZiekenhuisTheme {
        ZiekenhuisDropDown(
            items = listOf("10:00", "11:00", "12:00", "13:00", "14:00"),
            setSelected = {},
            defaultText = "Selecteer tijdstip"
        )
    }
}
