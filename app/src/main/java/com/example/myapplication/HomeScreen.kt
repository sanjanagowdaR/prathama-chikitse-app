package com.example.myapplication

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController) {

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFE3F2FD),
                        Color.White
                    )
                )
            )
    ) {

        // TOP BAR
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Column {

                Text(
                    text = "Pratham-Chikitse",
                    fontSize = 30.sp,
                    color = Color(0xFF0D47A1)
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "Emergency First Aid Guide",
                    fontSize = 16.sp,
                    color = Color.Gray
                )
            }

            IconButton(
                onClick = {
                    navController.navigate("settings")
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Settings,
                    contentDescription = "Settings",
                    tint = Color(0xFF0D47A1),
                    modifier = Modifier.size(32.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        // AI + MAP ROW
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            // 🧠 AI BUTTON
            Button(
                onClick = {
                    navController.navigate("ai")
                },
                modifier = Modifier.weight(1f)
            ) {
                Text(text = "🧠 AI Emergency")
            }

            Spacer(modifier = Modifier.width(10.dp))

            // 📍 GOOGLE MAP ICON BUTTON
            IconButton(
                onClick = {
                    openNearbyHospitals(context)
                }
            ) {
                Icon(
                    imageVector = Icons.Default.LocationOn,
                    contentDescription = "Nearby Hospitals",
                    tint = Color.Red,
                    modifier = Modifier.size(34.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        // EMERGENCY CARDS
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(8.dp)
        ) {

            items(emergencyList) { item ->

                Card(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                        .height(130.dp)
                        .clickable {
                            navController.navigate(item.title)
                        },
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 6.dp
                    )
                ) {

                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(12.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Icon(
                            imageVector = getIcon(item.title),
                            contentDescription = item.title,
                            tint = Color(0xFF1976D2),
                            modifier = Modifier.size(40.dp)
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        Text(
                            text = item.title,
                            fontSize = 16.sp
                        )
                    }
                }
            }
        }
    }
}

// ICON MAPPING
fun getIcon(title: String): ImageVector {
    return when (title) {

        "Snake Bite" -> Icons.Default.Warning
        "Burn" -> Icons.Default.Whatshot
        "Accident" -> Icons.Default.CarCrash
        "Fracture" -> Icons.Default.Build
        "Heart Attack" -> Icons.Default.Favorite
        "Choking" -> Icons.Default.Warning
        "Electric Shock" -> Icons.Default.Bolt

        else -> Icons.Default.Info
    }
}

