package com.example.a209329_maznursyafika_nazatulaini_project2.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.a209329_maznursyafika_nazatulaini_project2.viewmodel.MainViewModel

@Composable
fun ProfileScreen(viewModel: MainViewModel) {

    val primaryPink = Color(0xFFC2185B)
    val bg = Color(0xFFF8D7E3)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(bg)
            .padding(20.dp)
    ) {

        // ---------------- TITLE ----------------
        Text(
            text = "Profile",
            style = MaterialTheme.typography.headlineMedium,
            color = primaryPink
        )

        Spacer(modifier = Modifier.height(20.dp))

        // ---------------- PROFILE CARD ----------------
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(6.dp)
        ) {

            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "Maznur Syafika",
                    style = MaterialTheme.typography.titleLarge,
                    color = primaryPink
                )

                Text(
                    text = "Patient User",
                    color = Color.Gray
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        // ---------------- FIREBASE ACTION ----------------
        Button(
            onClick = { viewModel.donateToCommunity() },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(containerColor = primaryPink),
            shape = RoundedCornerShape(14.dp)
        ) {
            Text("Share to Community (Firebase)", color = Color.White)
        }

        Spacer(modifier = Modifier.height(12.dp))

        // ---------------- LOGOUT ----------------
        Button(
            onClick = { viewModel.navigate("login") },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray),
            shape = RoundedCornerShape(14.dp)
        ) {
            Text("Logout", color = Color.White)
        }
    }
}