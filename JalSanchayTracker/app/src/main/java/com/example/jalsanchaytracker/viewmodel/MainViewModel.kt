package com.example.jalsanchaytracker.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.jalsanchaytracker.data.AppDatabase
import com.example.jalsanchaytracker.data.RainfallHistory
import com.example.jalsanchaytracker.data.UserSetup
import com.example.jalsanchaytracker.repository.WaterRepository
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: WaterRepository
    val userSetup: LiveData<UserSetup?>
    val allHistory: LiveData<List<RainfallHistory>>
    val totalLitersSaved: LiveData<Double?>

    init {
        val setupDao = AppDatabase.getDatabase(application).userSetupDao()
        val historyDao = AppDatabase.getDatabase(application).rainfallHistoryDao()
        repository = WaterRepository(setupDao, historyDao)
        userSetup = repository.userSetup.asLiveData()
        allHistory = repository.allHistory.asLiveData()
        totalLitersSaved = repository.totalLitersSaved.asLiveData()
    }

    fun saveSetup(area: Double, capacity: Double, coefficient: Double) {
        viewModelScope.launch {
            repository.insertSetup(UserSetup(roofArea = area, tankCapacity = capacity, runoffCoefficient = coefficient))
        }
    }

    fun insertRainfall(rainfallMM: Double, litersSaved: Double, date: Long) {
        viewModelScope.launch {
            repository.insertRainfall(RainfallHistory(rainfallMM = rainfallMM, litersSaved = litersSaved, date = date))
        }
    }

    fun deleteRainfall(history: RainfallHistory) {
        viewModelScope.launch {
            repository.deleteRainfall(history)
        }
    }
}
