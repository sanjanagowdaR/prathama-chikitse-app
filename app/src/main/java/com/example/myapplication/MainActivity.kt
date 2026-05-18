package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            var darkMode by remember { mutableStateOf(false) }
            var selectedLanguage by remember { mutableStateOf("English") }

            val colors = if (darkMode) {
                darkColorScheme()
            } else {
                lightColorScheme()
            }

            MaterialTheme(colorScheme = colors) {
                AppNavigation(
                    darkMode = darkMode,
                    onDarkModeChange = { darkMode = it },
                    selectedLanguage = selectedLanguage,
                    onLanguageChange = { selectedLanguage = it }
                )
            }
        }
    }
}

@Composable
fun AppNavigation(
    darkMode: Boolean,
    onDarkModeChange: (Boolean) -> Unit,
    selectedLanguage: String,
    onLanguageChange: (String) -> Unit
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "splash"
    ) {
        composable("splash") {
            SplashScreen(navController)
        }

        composable("home") {
            HomeScreen(navController)
        }

        composable("ai") {
            AiScreen(selectedLanguage = selectedLanguage)
        }

        composable("settings") {
            SettingsScreen(
                darkMode = darkMode,
                onDarkModeChange = onDarkModeChange,
                selectedLanguage = selectedLanguage,
                onLanguageChange = onLanguageChange
            )
        }

        emergencyList.forEach { item ->
            composable(item.title) {
                DetailScreen(
                    navController = navController,
                    emergency = item,
                    selectedLanguage = selectedLanguage
                )
            }
        }
    }
}
