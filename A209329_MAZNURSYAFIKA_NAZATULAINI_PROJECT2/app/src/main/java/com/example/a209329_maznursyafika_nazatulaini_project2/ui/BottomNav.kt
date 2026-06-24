package com.example.a209329_maznursyafika_nazatulaini_project2.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.a209329_maznursyafika_nazatulaini_project2.viewmodel.MainViewModel

@Composable
fun BottomNav(viewModel: MainViewModel) {

    val currentScreen by viewModel.currentScreen.collectAsState()

    NavigationBar {

        // ---------------- HOME ----------------
        NavigationBarItem(
            icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
            label = { Text("Home") },
            selected = currentScreen == "home",
            onClick = { viewModel.navigate("home") }
        )

        // ---------------- SEARCH ----------------
        NavigationBarItem(
            icon = { Icon(Icons.Default.Search, contentDescription = "Search") },
            label = { Text("Search") },
            selected = currentScreen == "search",
            onClick = { viewModel.navigate("search") }
        )

        // ---------------- PROFILE ----------------
        NavigationBarItem(
            icon = { Icon(Icons.Default.Person, contentDescription = "Profile") },
            label = { Text("Profile") },
            selected = currentScreen == "profile",
            onClick = { viewModel.navigate("profile") }
        )
    }
}