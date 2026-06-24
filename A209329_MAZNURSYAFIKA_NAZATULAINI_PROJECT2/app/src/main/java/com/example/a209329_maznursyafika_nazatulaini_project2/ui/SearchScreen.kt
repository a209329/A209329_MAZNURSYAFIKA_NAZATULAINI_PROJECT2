package com.example.a209329_maznursyafika_nazatulaini_project2.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.a209329_maznursyafika_nazatulaini_project2.viewmodel.MainViewModel

@Composable
fun SearchScreen(viewModel: MainViewModel) {

    val primaryPink = Color(0xFFC2185B)
    val bg = Color(0xFFF8D7E3)

    val searchText by viewModel.searchText.collectAsState()
    val message by viewModel.message.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(bg)
            .padding(20.dp)
    ) {

        // ---------------- BACK ----------------
        IconButton(onClick = { viewModel.navigate("home") }) {
            Icon(
                Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "Back",
                tint = primaryPink
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        // ---------------- TITLE ----------------
        Text(
            text = "Search Doctor",
            style = MaterialTheme.typography.headlineSmall,
            color = primaryPink
        )

        Spacer(modifier = Modifier.height(16.dp))

        // ---------------- SEARCH BAR ----------------
        OutlinedTextField(
            value = searchText,
            onValueChange = {
                viewModel.updateSearch(it)
                viewModel.performSearch()
            },
            leadingIcon = {
                Icon(Icons.Default.Search, contentDescription = null)
            },
            placeholder = { Text("Search doctor or specialty") },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(14.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        // ---------------- RESULT TITLE ----------------
        Text("Results", color = primaryPink)

        Spacer(modifier = Modifier.height(10.dp))

        // ---------------- RESULT CARD ----------------
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(4.dp)
        ) {

            Column(modifier = Modifier.padding(16.dp)) {

                if (message.isNotEmpty()) {

                    Text(
                        text = message,
                        color = Color.Gray
                    )

                } else {

                    Text(
                        text = "Type something to search doctors",
                        color = Color.Gray
                    )
                }
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        // ---------------- QUICK TIPS ----------------
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {

            Column(modifier = Modifier.padding(14.dp)) {

                Text("Quick Search", color = primaryPink)

                Spacer(modifier = Modifier.height(6.dp))

                Text("• Dr. Sarah (Cardiologist)", color = Color.Gray)
                Text("• Dr. Amir (Dentist)", color = Color.Gray)
            }
        }
    }
}