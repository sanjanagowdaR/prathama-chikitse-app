package com.example.myapplication

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

@Composable
fun AiScreen(selectedLanguage: String) {
    val scope = rememberCoroutineScope()
    var userQuestion by remember { mutableStateOf("") }
    val isKannada = selectedLanguage == "Kannada"
    var aiResponse by remember {
        mutableStateOf(if (isKannada) "ಯಾವುದೇ ತುರ್ತು ಪರಿಸ್ಥಿತಿಯ ಬಗ್ಗೆ ಕೇಳಿ..." else "Ask about any emergency...")
    }
    var isLoading by remember { mutableStateOf(false) }

    val apiKey = "AIzaSyAicLy2UdYAavtw6ZOo09--47L_T_Ptc0E"

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        // TITLE
        Text(
            text = if (isKannada) "🧠 AI ತುರ್ತು ಸಹಾಯಕ" else "🧠 AI Emergency Assistant",
            fontSize = 28.sp,
            color = Color(0xFF0D47A1)
        )

        Spacer(modifier = Modifier.height(20.dp))

        // INPUT FIELD
        OutlinedTextField(
            value = userQuestion,
            onValueChange = { userQuestion = it },
            label = {
                Text(if (isKannada) "ತುರ್ತು ಪರಿಸ್ಥಿತಿಯನ್ನು ವಿವರಿಸಿ" else "Describe Emergency")
            },
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text(if (isKannada) "ಉದಾ: ಹಾವು, ಸುಟ್ಟ ಗಾಯ, ಆಸ್ತಮಾ..." else "e.g., snake bite, burn, asthma...") }
        )

        Spacer(modifier = Modifier.height(20.dp))

        // ASK BUTTON
        Button(
            onClick = {
                if (userQuestion.isBlank()) return@Button

                isLoading = true
                val question = userQuestion.lowercase()

                // 1. Instant Offline Logic
                val offlineAdvice = getOfflineAdvice(question, isKannada)

                if (offlineAdvice != null) {
                    aiResponse = offlineAdvice
                    isLoading = false
                } else {
                    // 2. Online Gemini AI Logic via Retrofit (v1)
                    aiResponse = if (isKannada) "AI ಯೋಚಿಸುತ್ತಿದೆ..." else "Gemini is thinking..."
                    scope.launch {
                        try {
                            val prompt = if (isKannada) {
                                "ನೀವು ತುರ್ತು ವೈದ್ಯಕೀಯ ಸಹಾಯಕರು. ಈ ಪ್ರಶ್ನೆಗೆ ಕನ್ನಡದಲ್ಲಿ ಸರಳ ಪ್ರಥಮ ಚಿಕಿತ್ಸಾ ಸಲಹೆ ನೀಡಿ: $userQuestion"
                            } else {
                                "You are an emergency medical assistant. Provide clear, direct first aid advice for: $userQuestion"
                            }

                            val request = GeminiRequest(
                                contents = listOf(Content(parts = listOf(Part(text = prompt))))
                            )

                            val response = RetrofitInstance.api.generateContent(apiKey, request)

                            if (response.isSuccessful) {
                                aiResponse = response.body()?.candidates?.firstOrNull()?.content?.parts?.firstOrNull()?.text
                                    ?: (if (isKannada) "ಉತ್ತರ ಸಿಗಲಿಲ್ಲ." else "No response.")
                            } else {
                                aiResponse = if (isKannada) "ದೋಷ: ಸರ್ವರ್ ಪ್ರತಿಕ್ರಿಯಿಸುತ್ತಿಲ್ಲ." else "Server error. Please try again later."
                            }
                        } catch (e: Exception) {
                            aiResponse = if (isKannada) "ದೋಷ: ಇಂಟರ್ನೆಟ್ ಸಂಪರ್ಕ ಪರೀಕ್ಷಿಸಿ." else "Connection failed. Please check your internet."
                        } finally {
                            isLoading = false
                        }
                    }
                }
            },
            modifier = Modifier.fillMaxWidth(),
            enabled = !isLoading
        ) {
            if (isLoading) {
                CircularProgressIndicator(color = Color.White, modifier = Modifier.size(24.dp))
            } else {
                Text(text = if (isKannada) "ಸಲಹೆ ಪಡೆಯಿರಿ" else "Get AI Advice", fontSize = 18.sp)
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // RESPONSE CARD
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFF3F6FA)),
            elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = aiResponse, fontSize = 18.sp, lineHeight = 24.sp)
            }
        }
    }
}

fun getOfflineAdvice(q: String, isKn: Boolean): String? {
    return when {
        "snake" in q || "ಹಾವು" in q -> if (isKn) "🐍 ಹಾವಿನ ಕಡಿತ: ಶಾಂತವಾಗಿರಿ, ಅಲುಗಾಡಿಸಬೇಡಿ, ತಕ್ಷಣ ಆಸ್ಪತ್ರೆಗೆ ಹೋಗಿ." else "🐍 Snake Bite: Stay calm, don't move, go to hospital immediately."
        "burn" in q || "ಸುಟ್ಟ" in q -> if (isKn) "🔥 ಸುಟ್ಟ ಗಾಯ: ತಣ್ಣೀರು ಸುರಿಯಿರಿ, ಬಟ್ಟೆಯಿಂದ ಮುಚ್ಚಿ, ಐಸ್ ಹಚ್ಚಬೇಡಿ." else "🔥 Burn: Cool with water, cover with cloth, no ice."
        "asthma" in q || "ಆಸ್ತಮಾ" in q -> if (isKn) "🫁 ಆಸ್ತಮಾ: ನೇರವಾಗಿ ಕುಳಿತುಕೊಳ್ಳಿ, ಇನ್ಹೇಲರ್ ಬಳಸಿ." else "🫁 Asthma: Sit upright, help use inhaler."
        "heart" in q || "ಹೃದಯ" in q -> if (isKn) "❤️ ಹೃದಯಾಘಾತ: ಕುಳಿತುಕೊಳ್ಳಲು ಸಹಾಯ ಮಾಡಿ, ಅಂಬ್ಯುಲೆನ್ಸ್ ಕರೆ ಮಾಡಿ." else "❤️ Heart Attack: Help sit, loosen clothes, call ambulance."
        "stroke" in q || "ಪಾರ್ಶ್ವವಾಯು" in q -> if (isKn) "🧠 ಪಾರ್ಶ್ವವಾಯು: ಕೂಡಲೇ ಅಂಬ್ಯುಲೆನ್ಸ್ ಕರೆ ಮಾಡಿ, ಆಹಾರ ನೀಡಬೇಡಿ." else "🧠 Stroke: Call ambulance, note time, no food/water."
        "choking" in q || "ಗಂಟಲಲ್ಲಿ" in q -> if (isKn) "😮 ಉಸಿರುಕಟ್ಟುವಿಕೆ: ಬೆನ್ನಿನ ಮೇಲೆ ತಟ್ಟಿ, ಹೈಮ್ಲಿಕ್ ತಂತ್ರ ಬಳಸಿ." else "😮 Choking: 5 back blows, Heimlich maneuver."
        "nose" in q || "ಮೂಗಿನ" in q -> if (isKn) "👃 ಮೂಗಿನ ರಕ್ತಸ್ರಾವ: ಮುಂದಕ್ಕೆ ಬಾಗಿ ಕುಳಿತುಕೊಳ್ಳಿ, ಮೂಗು ಒತ್ತಿ ಹಿಡಿಯಿರಿ." else "👃 Nosebleed: Lean forward, pinch nose for 10 mins."
        "diabetic" in q || "sugar" in q || "ಮಧುಮೇಹ" in q -> if (isKn) "🍬 ಮಧುಮೇಹ: ಪ್ರಜ್ಞೆ ಇದ್ದರೆ ಸಕ್ಕರೆ/ಗ್ಲೂಕೋಸ್ ನೀಡಿ." else "🍬 Diabetic: Give sugar/glucose if conscious."
        "eye" in q || "ಕಣ್ಣಿನ" in q -> if (isKn) "👁️ ಕಣ್ಣಿನ ಗಾಯ: ಉಜ್ಜಬೇಡಿ, ನೀರಿನಿಂದ ತೊಳೆಯಿರಿ, ವೈದ್ಯರ ಬಳಿ ಹೋಗಿ." else "👁️ Eye Injury: Don't rub, flush with water, see doctor."
        "fracture" in q || "ಮೂಳೆ" in q -> if (isKn) "🦴 ಮೂಳೆ ಮುರಿತ: ಅಲುಗಾಡಿಸಬೇಡಿ, ಆಧಾರ ನೀಡಿ, ಐಸ್ ಪ್ಯಾಕ್ ಬಳಸಿ." else "🦴 Fracture: Don't move, apply support, use ice."
        "electric" in q || "ವಿದ್ಯುತ್" in q -> if (isKn) "⚡ ವಿದ್ಯುತ್ ಆಘಾತ: ಪವರ್ ಆಫ್ ಮಾಡಿ, ಒಣ ವಸ್ತುವಿನಿಂದ ಬೇರ್ಪಡಿಸಿ." else "⚡ Electric Shock: Turn off power, separate with dry object."
        "accident" in q || "ಅಪಘಾತ" in q -> if (isKn) "🚗 ಅಪಘಾತ: ಅಂಬ್ಯುಲೆನ್ಸ್ ಕರೆ ಮಾಡಿ, ರಕ್ತಸ್ರಾವ ನಿಯಂತ್ರಿಸಿ." else "🚗 Accident: Call ambulance, control bleeding."
        else -> null
    }
}