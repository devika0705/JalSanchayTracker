package com.example.jalsanchaytracker.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface RainfallHistoryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRainfall(history: RainfallHistory)

    @Delete
    suspend fun deleteRainfall(history: RainfallHistory)

    @Query("SELECT * FROM rainfall_history ORDER BY date DESC")
    fun getAllHistory(): Flow<List<RainfallHistory>>
    
    @Query("SELECT SUM(litersSaved) FROM rainfall_history")
    fun getTotalLitersSaved(): Flow<Double?>
    
    // For monthly reports, we might fetch all and filter in memory for simplicity or use SQLite date functions
    @Query("SELECT * FROM rainfall_history WHERE date >= :startDate AND date <= :endDate ORDER BY date ASC")
    fun getHistoryBetweenDates(startDate: Long, endDate: Long): Flow<List<RainfallHistory>>
}
