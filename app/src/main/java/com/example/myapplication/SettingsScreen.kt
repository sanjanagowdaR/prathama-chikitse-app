package com.example.myapplication

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SettingsScreen(
    darkMode: Boolean,
    onDarkModeChange: (Boolean) -> Unit,
    selectedLanguage: String,
    onLanguageChange: (String) -> Unit
) {

    var voiceEnabled by remember {
        mutableStateOf(true)
    }

    var notificationsEnabled by remember {
        mutableStateOf(true)
    }

    var showLanguageDialog by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {

        // TITLE
        Row(verticalAlignment = Alignment.CenterVertically) {

            Icon(
                imageVector = Icons.Default.Settings,
                contentDescription = null,
                tint = Color(0xFF0D47A1)
            )

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = if (selectedLanguage == "Kannada") "ಸಂಯೋಜನೆಗಳು" else "Settings",
                fontSize = 28.sp,
                color = Color(0xFF0D47A1)
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        // LANGUAGE SELECTION
        Card(
            modifier = Modifier.fillMaxWidth(),
            onClick = { showLanguageDialog = true }
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = if (selectedLanguage == "Kannada") "ಭಾಷೆ" else "Language",
                    fontSize = 18.sp
                )
                Text(
                    text = selectedLanguage,
                    fontSize = 16.sp,
                    color = Color.Gray
                )
            }
        }

        if (showLanguageDialog) {
            AlertDialog(
                onDismissRequest = { showLanguageDialog = false },
                title = { Text(text = "Select Language") },
                text = {
                    Column {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth().padding(8.dp)
                        ) {
                            RadioButton(
                                selected = selectedLanguage == "English",
                                onClick = { onLanguageChange("English"); showLanguageDialog = false }
                            )
                            Text("English", modifier = Modifier.padding(start = 8.dp))
                        }
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth().padding(8.dp)
                        ) {
                            RadioButton(
                                selected = selectedLanguage == "Kannada",
                                onClick = { onLanguageChange("Kannada"); showLanguageDialog = false }
                            )
                            Text("ಕನ್ನಡ (Kannada)", modifier = Modifier.padding(start = 8.dp))
                        }
                    }
                },
                confirmButton = {
                    TextButton(onClick = { showLanguageDialog = false }) {
                        Text("Cancel")
                    }
                }
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // DARK MODE
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),

                horizontalArrangement =
                    Arrangement.SpaceBetween
            ) {

                Text(
                    text = if (selectedLanguage == "Kannada") "ಡಾರ್ಕ್ ಮೋಡ್" else "Dark Mode",
                    fontSize = 18.sp
                )

                Switch(
                    checked = darkMode,

                    onCheckedChange = {
                        onDarkModeChange(it)
                    }
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // VOICE
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),

                horizontalArrangement =
                    Arrangement.SpaceBetween
            ) {

                Text(
                    text = if (selectedLanguage == "Kannada") "ಧ್ವನಿ ಸೂಚನೆಗಳು" else "Voice Instructions",
                    fontSize = 18.sp
                )

                Switch(
                    checked = voiceEnabled,

                    onCheckedChange = {
                        voiceEnabled = it
                    }
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // NOTIFICATIONS
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),

                horizontalArrangement =
                    Arrangement.SpaceBetween
            ) {

                Text(
                    text = if (selectedLanguage == "Kannada") "ತುರ್ತು ಅಧಿಸೂಚನೆಗಳು" else "Emergency Notifications",
                    fontSize = 18.sp
                )

                Switch(
                    checked = notificationsEnabled,

                    onCheckedChange = {
                        notificationsEnabled = it
                    }
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // ABOUT APP
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {

            Column(
                modifier = Modifier.padding(16.dp)
            ) {

                Text(
                    text = if (selectedLanguage == "Kannada") "ಅಪ್ಲಿಕೇಶನ್ ಬಗ್ಗೆ" else "About App",
                    fontSize = 20.sp,
                    color = Color(0xFF0D47A1)
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = if (selectedLanguage == "Kannada") 
                        "ಪ್ರಥಮ-ಚಿಕಿತ್ಸೆಯು ತುರ್ತು ಸಂದರ್ಭಗಳಲ್ಲಿ ಬಳಕೆದಾರರಿಗೆ ಪ್ರಥಮ ಚಿಕಿತ್ಸಾ ಮಾರ್ಗದರ್ಶನ ಮತ್ತು AI ಸಹಾಯದೊಂದಿಗೆ ಸಹಾಯ ಮಾಡುತ್ತದೆ."
                    else 
                        "Pratham-Chikitse helps users during emergencies with first aid guidance and AI assistance."
                )
            }
        }
    }
}
