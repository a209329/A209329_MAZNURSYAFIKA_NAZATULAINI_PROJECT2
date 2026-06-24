package com.example.a209329_maznursyafika_nazatulaini_project2.database

import kotlinx.coroutines.flow.Flow

class AppointmentRepository(
    private val dao: AppointmentDao
) {
    val allAppointments: Flow<List<AppointmentEntity>> =
        dao.getAllAppointments()

    suspend fun insertAppointment(appointment: AppointmentEntity) {
        dao.insertAppointment(appointment)
    }
}