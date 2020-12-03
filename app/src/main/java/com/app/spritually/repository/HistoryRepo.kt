package com.app.spritually.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.app.spritually.dao.HistoryDao
import com.app.spritually.dao.HistoryDatabase
import com.app.spritually.model.HistoryModel

class HistoryRepo(application: Application) {

    private val historyDao: HistoryDao
    val allData:LiveData<List<HistoryModel>>

    val historyCount: LiveData<Int>
        get() = historyDao.count

    init {
        val historyDatabase = HistoryDatabase.getInstance(application)
        historyDao = historyDatabase.historyDao()
        allData = historyDao.allData
    }

    suspend fun insert(historyModel: HistoryModel){
        historyDao.insert(historyModel)
    }

    suspend fun update(historyModel: HistoryModel){
        historyDao.update(historyModel)
    }

    suspend fun delete(historyModel: HistoryModel){
        historyDao.delete(historyModel)
    }

    suspend fun clearAllData(){
        historyDao.clearAllData()
    }
}