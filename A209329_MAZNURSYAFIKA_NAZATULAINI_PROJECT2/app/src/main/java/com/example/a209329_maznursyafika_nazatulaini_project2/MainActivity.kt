package com.example.a209329_maznursyafika_nazatulaini_project2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.room.Room
import com.example.a209329_maznursyafika_nazatulaini_project2.database.HospitalDatabase
import com.example.a209329_maznursyafika_nazatulaini_project2.database.AppointmentRepository
import com.example.a209329_maznursyafika_nazatulaini_project2.ui.*
import com.example.a209329_maznursyafika_nazatulaini_project2.ui.theme.AppTheme
import com.example.a209329_maznursyafika_nazatulaini_project2.viewmodel.MainViewModel
import com.example.a209329_maznursyafika_nazatulaini_project2.viewmodel.MainViewModelFactory
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val db = Room.databaseBuilder(
            applicationContext,
            HospitalDatabase::class.java,
            "hospital_database"
        ).build()

        val repository = AppointmentRepository(db.appointmentDao())

        setContent {
            AppTheme {

                val viewModel: MainViewModel = viewModel(
                    factory = MainViewModelFactory(repository)
                )

                when (viewModel.currentScreen.collectAsState().value) {

                    "login" -> LoginScreen(viewModel)
                    "signup" -> SignUpScreen(viewModel)
                    "home" -> HomeScreen(viewModel)
                    "doctorDetails" -> DoctorDetailsScreen(viewModel)
                    "booking" -> BookingScreen(viewModel)
                    "search" -> SearchScreen(viewModel)
                    "profile" -> ProfileScreen(viewModel)

                    else -> LoginScreen(viewModel)
                }
            }
        }
    }
}