package com.example.a209329_maznursyafika_nazatulaini_project2.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.a209329_maznursyafika_nazatulaini_project2.database.AppointmentEntity
import com.example.a209329_maznursyafika_nazatulaini_project2.database.AppointmentRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel(
    private val repository: AppointmentRepository
) : ViewModel() {

    // ---------------- NAVIGATION ----------------
    val currentScreen = MutableStateFlow("login")

    fun navigate(screen: String) {
        currentScreen.value = screen
    }

    // ---------------- SEARCH ----------------
    val searchText = MutableStateFlow("")
    val message = MutableStateFlow("")

    fun updateSearch(text: String) {
        searchText.value = text
    }

    fun performSearch() {
        message.value =
            if (searchText.value.isNotBlank())
                "Searching for ${searchText.value}"
            else
                "Please enter something"
    }

    // ---------------- DOCTOR ----------------
    val selectedDoctor = MutableStateFlow("")
    val selectedDate = MutableStateFlow("12 April 2026")
    val selectedTime = MutableStateFlow("10:00 AM")

    fun openDoctor(name: String) {
        selectedDoctor.value = name
        currentScreen.value = "doctorDetails"
    }

    // ---------------- ROOM DATABASE ----------------
    private val _appointments =
        MutableStateFlow<List<AppointmentEntity>>(emptyList())

    val appointments: StateFlow<List<AppointmentEntity>>
        get() = _appointments

    init {
        viewModelScope.launch {
            repository.allAppointments.collect {
                _appointments.value = it
            }
        }
    }

    fun confirmBooking() {
        viewModelScope.launch {

            repository.insertAppointment(
                AppointmentEntity(
                    doctorName = selectedDoctor.value,
                    date = selectedDate.value,
                    time = selectedTime.value
                )
            )

            currentScreen.value = "home"
        }
    }

    // ---------------- API ----------------
    private val _weatherResult = MutableStateFlow("Not loaded")
    val weatherResult: StateFlow<String>
        get() = _weatherResult

    fun loadWeather(city: String) {
        _weatherResult.value = "Sunny 30°C in $city"
    }
    // ---------------- GPS ----------------
    private val _locationText = MutableStateFlow("Unknown")
    val locationText: StateFlow<String>
        get() = _locationText

    fun loadLocation() {
        _locationText.value = "Penang, Malaysia"
    }

    // ---------------- DONATION ----------------
    fun donateToCommunity() {
        // placeholder
    }
}