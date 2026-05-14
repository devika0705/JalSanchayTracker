package com.example.jalsanchaytracker.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface UserSetupDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSetup(setup: UserSetup)

    @Query("SELECT * FROM user_setup WHERE id = 1")
    fun getSetup(): Flow<UserSetup?>
    
    @Query("DELETE FROM user_setup")
    suspend fun clearSetup()
}
