package com.example.jalsanchaytracker.repository

import com.example.jalsanchaytracker.data.RainfallHistory
import com.example.jalsanchaytracker.data.RainfallHistoryDao
import com.example.jalsanchaytracker.data.UserSetup
import com.example.jalsanchaytracker.data.UserSetupDao
import kotlinx.coroutines.flow.Flow

class WaterRepository(
    private val setupDao: UserSetupDao,
    private val historyDao: RainfallHistoryDao
) {
    val userSetup: Flow<UserSetup?> = setupDao.getSetup()
    val allHistory: Flow<List<RainfallHistory>> = historyDao.getAllHistory()
    val totalLitersSaved: Flow<Double?> = historyDao.getTotalLitersSaved()

    suspend fun insertSetup(setup: UserSetup) {
        setupDao.insertSetup(setup)
    }

    suspend fun clearSetup() {
        setupDao.clearSetup()
    }

    suspend fun insertRainfall(history: RainfallHistory) {
        historyDao.insertRainfall(history)
    }

    suspend fun deleteRainfall(history: RainfallHistory) {
        historyDao.deleteRainfall(history)
    }
    
    fun getHistoryBetweenDates(startDate: Long, endDate: Long): Flow<List<RainfallHistory>> {
        return historyDao.getHistoryBetweenDates(startDate, endDate)
    }
}
