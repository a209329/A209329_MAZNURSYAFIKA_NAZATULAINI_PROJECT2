package com.example.a209329_maznursyafika_nazatulaini_project2.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface AppointmentDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAppointment(appointment: AppointmentEntity)

    @Query("SELECT * FROM appointment_table ORDER BY id DESC")
    fun getAllAppointments(): Flow<List<AppointmentEntity>>

}