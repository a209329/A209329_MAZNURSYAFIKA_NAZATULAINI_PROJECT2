package com.example.a209329_maznursyafika_nazatulaini_project2.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.a209329_maznursyafika_nazatulaini_project2.viewmodel.MainViewModel

@Composable
fun DoctorDetailsScreen(viewModel: MainViewModel) {

    val primaryPink = Color(0xFFC2185B)
    val lightPinkBg = Color(0xFFF8D7E3)

    val doctorName by viewModel.selectedDoctor.collectAsState()

    val doctorInfo = when (doctorName) {
        "Dr. Amir" ->
            "Dr. Amir is a professional dentist with over 8 years of experience in dental surgery, braces, and oral care treatments."
        else ->
            "Dr. Sarah is a highly experienced cardiologist with more than 10 years of experience in treating heart related diseases."
    }

    val specialty = when (doctorName) {
        "Dr. Amir" -> "Dentist"
        else -> "Cardiologist"
    }

    val categories = when (doctorName) {
        "Dr. Amir" -> listOf("Dental Care", "Teeth Cleaning")
        else -> listOf("Cardiology", "Heart Check", "ECG")
    }

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

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                IconButton(onClick = { viewModel.navigate("home") }) {
                    Icon(
                        Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back",
                        tint = primaryPink
                    )
                }

                Icon(
                    Icons.Default.MoreVert,
                    contentDescription = "Menu",
                    tint = primaryPink
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            Box(
                modifier = Modifier
                    .size(110.dp)
                    .align(Alignment.CenterHorizontally)
                    .clip(CircleShape)
                    .background(Color.White),
                contentAlignment = Alignment.Center
            ) {
                Text("👩‍⚕️")
            }

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = doctorName,
                style = MaterialTheme.typography.headlineSmall,
                color = primaryPink,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Text(
                text = specialty,
                color = Color.Gray,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = "⭐ 4.8 (120 reviews)",
                modifier = Modifier.align(Alignment.CenterHorizontally),
                color = Color.DarkGray
            )

            Spacer(modifier = Modifier.height(18.dp))

            InfoCard("About", primaryPink) {
                Text(doctorInfo, color = Color.Gray)
            }

            Spacer(modifier = Modifier.height(12.dp))

            InfoCard("Category", primaryPink) {
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    categories.forEachIndexed { index, item ->
                        Chip(item, index == 0, primaryPink)
                    }
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            InfoCard("Availability", primaryPink) {
                Text("Mon - Sat\n09:00 AM - 05:00 PM", color = Color.Gray)
            }

            Spacer(modifier = Modifier.height(12.dp))

            InfoCard("Consultation Fee", primaryPink) {
                Text("RM80.00", color = primaryPink)
            }

            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = { viewModel.navigate("booking") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp),
                colors = ButtonDefaults.buttonColors(containerColor = primaryPink),
                shape = RoundedCornerShape(16.dp)
            ) {
                Text("Book Appointment", color = Color.White)
            }
        }
    }
}

/* ================= COMPONENTS ================= */

@Composable
fun InfoCard(
    title: String,
    primaryPink: Color,
    content: @Composable ColumnScope.() -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(14.dp)) {

            Text(text = title, color = primaryPink)

            Spacer(modifier = Modifier.height(6.dp))

            content()
        }
    }
}

@Composable
fun Chip(
    text: String,
    selected: Boolean,
    primaryPink: Color
) {
    Surface(
        shape = RoundedCornerShape(20.dp),
        color = if (selected) primaryPink else Color(0xFFF5F5F5)
    ) {
        Text(
            text = text,
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
            color = if (selected) Color.White else Color.Gray
        )
    }
}