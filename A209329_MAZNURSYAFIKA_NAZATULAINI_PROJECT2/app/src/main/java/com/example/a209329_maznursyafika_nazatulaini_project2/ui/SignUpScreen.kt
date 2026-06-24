package com.example.a209329_maznursyafika_nazatulaini_project2.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.example.a209329_maznursyafika_nazatulaini_project2.viewmodel.MainViewModel

@Composable
fun SignUpScreen(viewModel: MainViewModel) {

    val primaryPink = Color(0xFFC2185B)
    val bg = Color(0xFFF8D7E3)

    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(bg)
            .padding(20.dp)
    ) {

        // ---------------- BACK BUTTON ----------------
        IconButton(onClick = { viewModel.navigate("login") }) {
            Icon(
                Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "Back",
                tint = primaryPink
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        // ---------------- TITLE ----------------
        Text(
            text = "Create Account",
            style = MaterialTheme.typography.headlineMedium,
            color = primaryPink
        )

        Text(
            text = "Register to continue",
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(20.dp))

        // ---------------- NAME ----------------
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            leadingIcon = { Icon(Icons.Default.Person, contentDescription = null) },
            placeholder = { Text("Full Name") },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp)
        )

        Spacer(modifier = Modifier.height(12.dp))

        // ---------------- EMAIL ----------------
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            leadingIcon = { Icon(Icons.Default.Email, contentDescription = null) },
            placeholder = { Text("Email") },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp)
        )

        Spacer(modifier = Modifier.height(12.dp))

        // ---------------- PASSWORD ----------------
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            leadingIcon = { Icon(Icons.Default.Lock, contentDescription = null) },
            placeholder = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp)
        )

        Spacer(modifier = Modifier.height(25.dp))

        // ---------------- SIGN UP BUTTON ----------------
        Button(
            onClick = {
                // you can later connect Firebase Auth here
                viewModel.navigate("login")
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(containerColor = primaryPink),
            shape = RoundedCornerShape(14.dp)
        ) {
            Text("Sign Up", color = Color.White)
        }

        Spacer(modifier = Modifier.height(12.dp))

        // ---------------- LOGIN NAV ----------------
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text("Already have an account? ")
            TextButton(onClick = { viewModel.navigate("login") }) {
                Text("Login", color = primaryPink)
            }
        }
    }
}