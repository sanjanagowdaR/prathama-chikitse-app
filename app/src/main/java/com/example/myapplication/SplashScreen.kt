package com.example.myapplication

import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {

    var startAnimation by remember {
        mutableStateOf(false)
    }

    val scale by animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0.7f,

        animationSpec = tween(
            durationMillis = 1500
        ),

        label = ""
    )

    LaunchedEffect(true) {

        startAnimation = true

        delay(2500)

        navController.navigate("home") {

            popUpTo("splash") {
                inclusive = true
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF0D47A1),
                        Color(0xFF42A5F5)
                    )
                )
            ),

        contentAlignment = Alignment.Center
    ) {

        Column(
            horizontalAlignment =
                Alignment.CenterHorizontally
        ) {

            Image(
                painter = painterResource(
                    id = R.drawable.ic_launcher_foreground
                ),

                contentDescription = "Logo",

                modifier = Modifier
                    .size(140.dp)
                    .scale(scale)
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Pratham-Chikitse",
                fontSize = 34.sp,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Emergency First Aid Guide",
                fontSize = 18.sp,
                color = Color.White
            )
        }
    }
}

