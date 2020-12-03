package com.app.spritually.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.app.spritually.model.HistoryModel

interface HistoryDao {

    // Get All History
    @get:Query("SELECT * FROM history_db")
    val allData: LiveData<List<HistoryModel>>

    // Get the Count of the Data
    @get:Query("SELECT COUNT(*) FROM history_db")
    val count: LiveData<Int>

    // Insert an entry. Will ignore insertion if trackingId is the same
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(scannerListModel: HistoryModel)

    // Update an entry
    @Update
    suspend fun update(scannerListModel: HistoryModel)

    // Delete an entry
    @Delete
    suspend fun delete(scannerListModel: HistoryModel)

    // Delete All Entries
    @Query("DELETE FROM hisorty_db")
    suspend fun clearAllData()


}