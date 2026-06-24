package com.example.a209329_maznursyafika_nazatulaini_project2.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "appointment_table")
data class AppointmentEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val doctorName: String,
    val date: String,
    val time: String
)