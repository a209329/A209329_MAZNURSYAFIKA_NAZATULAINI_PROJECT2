package com.example.a209329_maznursyafika_nazatulaini_project2.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.a209329_maznursyafika_nazatulaini_project2.viewmodel.MainViewModel

@Composable
fun BookingScreen(viewModel: MainViewModel) {

    val primaryPink = Color(0xFFC2185B)
    val lightPinkBg = Color(0xFFF8D7E3)

    // ✅ StateFlow properly collected
    val selectedDoctor by viewModel.selectedDoctor.collectAsState()
    val selectedDate by viewModel.selectedDate.collectAsState()
    val selectedTime by viewModel.selectedTime.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(lightPinkBg)
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {

            // ---------------- BACK BUTTON ----------------
            IconButton(onClick = { viewModel.navigate("home") }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back",
                    tint = primaryPink
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Book Appointment",
                style = MaterialTheme.typography.headlineSmall,
                color = primaryPink
            )

            Spacer(modifier = Modifier.height(20.dp))

            // ---------------- APPOINTMENT CARD ----------------
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(6.dp)
            ) {

                Column(modifier = Modifier.padding(16.dp)) {

                    Text("Selected Doctor", color = Color.Gray)

                    Text(
                        text = selectedDoctor.ifEmpty { "No doctor selected" },
                        color = primaryPink
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Text("Selected Date", color = Color.Gray)

                    Text(
                        text = selectedDate,
                        color = primaryPink
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Text("Selected Time", color = Color.Gray)

                    Text(
                        text = selectedTime,
                        color = primaryPink
                    )
                }
            }

            Spacer(modifier = Modifier.height(25.dp))

            // ---------------- ROOM SAVE BUTTON ----------------
            Button(
                onClick = { viewModel.confirmBooking() },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(containerColor = primaryPink),
                shape = RoundedCornerShape(14.dp)
            ) {
                Text("Confirm Booking (Save to Room)", color = Color.White)
            }

            Spacer(modifier = Modifier.height(12.dp))

            // ---------------- FIREBASE BUTTON ----------------
            Button(
                onClick = { viewModel.donateToCommunity() },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6A1B9A)),
                shape = RoundedCornerShape(14.dp)
            ) {
                Text("Donate to Community (Firebase)", color = Color.White)
            }
        }
    }
}