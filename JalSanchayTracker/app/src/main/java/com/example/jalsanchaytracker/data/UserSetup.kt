package com.example.jalsanchaytracker.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_setup")
data class UserSetup(
    @PrimaryKey val id: Int = 1, // Only one setup row expected
    val roofArea: Double,
    val tankCapacity: Double,
    val runoffCoefficient: Double
)
