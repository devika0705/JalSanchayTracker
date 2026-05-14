package com.example.jalsanchaytracker.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "rainfall_history")
data class RainfallHistory(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val rainfallMM: Double,
    val litersSaved: Double,
    val date: Long // store date as timestamp
)
