package com.example.a209329_maznursyafika_nazatulaini_project2.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.a209329_maznursyafika_nazatulaini_project2.viewmodel.MainViewModel

@Composable
fun HomeScreen(viewModel: MainViewModel) {

    val searchText by viewModel.searchText.collectAsState()
    val message by viewModel.message.collectAsState()
    val appointments by viewModel.appointments.collectAsState()

    // 🌐 API (Web Data - RUBRIC requirement)
    val weather by viewModel.weatherResult.collectAsState()

    // 📍 GPS (Sensor requirement)
    val location by viewModel.locationText.collectAsState()

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF8D7E3))
            .padding(16.dp)
    ) {

        // ---------------- TITLE ----------------
        Text(
            text = "MS Executive Health Care",
            style = MaterialTheme.typography.headlineSmall,
            color = Color(0xFFC2185B)
        )

        Spacer(Modifier.height(12.dp))

        // ---------------- SEARCH ----------------
        OutlinedTextField(
            value = searchText,
            onValueChange = {
                viewModel.updateSearch(it)
                viewModel.performSearch()
            },
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text("Search doctor") }
        )

        Spacer(Modifier.height(10.dp))

        // ---------------- API BUTTON ----------------
        Button(
            onClick = { viewModel.loadWeather("Penang") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Load Health Weather (API)")
        }

        Text(text = "Weather: $weather")

        Spacer(Modifier.height(10.dp))

        // ---------------- GPS BUTTON ----------------
        Button(
            onClick = { viewModel.loadLocation() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Get My Location (GPS)")
        }

        Text(text = "Location: $location")

        Spacer(Modifier.height(12.dp))

        // ---------------- SEARCH MESSAGE ----------------
        if (message.isNotEmpty()) {
            Text(
                text = message,
                color = Color(0xFFC2185B)
            )
        }

        Spacer(Modifier.height(12.dp))

        // ---------------- DOCTORS ----------------
        Text("Doctors", color = Color(0xFFC2185B))

        DoctorCard("Dr. Sarah") { viewModel.openDoctor("Dr. Sarah") }
        DoctorCard("Dr. Amir") { viewModel.openDoctor("Dr. Amir") }

        Spacer(Modifier.height(16.dp))

        // ---------------- BOOKINGS ----------------
        Text("My Bookings", color = Color(0xFFC2185B))

        appointments.forEach { item ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(
                    text = "${item.doctorName} - ${item.date} - ${item.time}",
                    modifier = Modifier.padding(12.dp)
                )
            }
        }

        Spacer(Modifier.weight(1f))

        BottomNav(viewModel)
    }
}

@Composable
fun DoctorCard(name: String, onClick: () -> Unit) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        onClick = onClick,
        shape = RoundedCornerShape(12.dp)
    ) {
        Text(
            text = name,
            modifier = Modifier.padding(12.dp)
        )
    }
}