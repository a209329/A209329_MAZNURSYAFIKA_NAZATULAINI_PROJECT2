package com.example.a209329_maznursyafika_nazatulaini_project2.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [AppointmentEntity::class],
    version = 1,
    exportSchema = false
)
abstract class HospitalDatabase : RoomDatabase() {

    abstract fun appointmentDao(): AppointmentDao

    companion object
}