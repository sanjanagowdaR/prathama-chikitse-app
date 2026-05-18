package com.example.myapplication

import android.speech.tts.TextToSpeech
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Stop
import androidx.compose.material.icons.filled.VolumeUp
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import java.util.*

@Composable
fun DetailScreen(
    navController: NavController,
    emergency: Emergency,
    selectedLanguage: String
) {
    val context = LocalContext.current
    val isKannada = selectedLanguage == "Kannada"
    var isTtsReady by remember { mutableStateOf(false) }
    var isSpeaking by remember { mutableStateOf(false) }

    val tts = remember {
        TextToSpeech(context) { status ->
            if (status == TextToSpeech.SUCCESS) {
                isTtsReady = true
            }
        }
    }

    // Configure language for TTS
    LaunchedEffect(isTtsReady, selectedLanguage) {
        if (isTtsReady) {
            val locale = if (isKannada) Locale("kn", "IN") else Locale.US
            tts.language = locale
        }
    }

    // Clean up TTS on dispose
    DisposableEffect(Unit) {
        onDispose {
            tts.stop()
            tts.shutdown()
        }
    }

    var showSteps by remember { mutableStateOf(true) }
    var showDos by remember { mutableStateOf(false) }
    var showDonts by remember { mutableStateOf(false) }

    val title = if (isKannada) emergency.titleKn else emergency.title
    val steps = if (isKannada) emergency.stepsKn else emergency.steps
    val dos = if (isKannada) emergency.dosKn else emergency.dos
    val donts = if (isKannada) emergency.dontsKn else emergency.donts

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        // 🔙 Top Bar
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back"
                )
            }

            Text(
                text = title,
                fontSize = 26.sp,
                color = Color(0xFF0D47A1)
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        // 📌 STEPS CARD
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            onClick = { showSteps = !showSteps }
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = if (isKannada) "📌 ಹಂತಗಳು" else "📌 Steps",
                    fontSize = 20.sp,
                    color = Color(0xFF0D47A1)
                )

                if (showSteps) {
                    Spacer(modifier = Modifier.height(10.dp))
                    steps.forEachIndexed { index, step ->
                        Text(
                            text = "${index + 1}. $step",
                            fontSize = 17.sp,
                            modifier = Modifier.padding(vertical = 4.dp)
                        )
                    }
                }
            }
        }

        // ✅ DO’S CARD
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFE8F5E9)),
            onClick = { showDos = !showDos }
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = if (isKannada) "✅ ಮಾಡಬೇಕಾದವುಗಳು" else "✅ Do’s",
                    color = Color(0xFF2E7D32),
                    fontSize = 20.sp
                )

                if (showDos) {
                    Spacer(modifier = Modifier.height(10.dp))
                    dos.forEach {
                        Text(
                            text = "✔ $it",
                            fontSize = 17.sp,
                            modifier = Modifier.padding(vertical = 4.dp)
                        )
                    }
                }
            }
        }

        // ❌ DON'TS CARD
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFFFEBEE)),
            onClick = { showDonts = !showDonts }
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = if (isKannada) "❌ ಮಾಡಬಾರದವುಗಳು" else "❌ Don’ts",
                    color = Color.Red,
                    fontSize = 20.sp
                )

                if (showDonts) {
                    Spacer(modifier = Modifier.height(10.dp))
                    donts.forEach {
                        Text(
                            text = "✘ $it",
                            fontSize = 17.sp,
                            modifier = Modifier.padding(vertical = 4.dp)
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // 🔊 AUDIO CONTROLS
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Button(
                onClick = {
                    if (isTtsReady) {
                        isSpeaking = true
                        val textToSpeak = steps.joinToString(". ")
                        tts.speak(textToSpeak, TextToSpeech.QUEUE_FLUSH, null, "steps_id")
                    }
                },
                modifier = Modifier.weight(1f),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0D47A1))
            ) {
                Icon(Icons.Default.VolumeUp, contentDescription = null)
                Spacer(Modifier.width(8.dp))
                Text(if (isKannada) "ಸೂಚನೆಗಳನ್ನು ಕೇಳಿ" else "Listen", fontSize = 16.sp)
            }

            if (isSpeaking) {
                Button(
                    onClick = {
                        tts.stop()
                        isSpeaking = false
                    },
                    modifier = Modifier.weight(1f),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
                ) {
                    Icon(Icons.Default.Stop, contentDescription = null)
                    Spacer(Modifier.width(8.dp))
                    Text(if (isKannada) "ನಿಲ್ಲಿಸಿ" else "Stop", fontSize = 16.sp)
                }
            }
        }

        Spacer(modifier = Modifier.height(40.dp))
    }
}
