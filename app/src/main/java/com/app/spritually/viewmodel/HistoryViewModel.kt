package com.app.spritually.viewmodel

import android.app.Application
import androidx.annotation.NonNull
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.app.spritually.model.HistoryModel
import com.app.spritually.repository.HistoryRepo
import kotlinx.coroutines.launch

class HistoryViewModel(@NonNull application: Application):AndroidViewModel(application) {
    private var repository: HistoryRepo = HistoryRepo(application)
    private var allData: LiveData<List<HistoryModel>>

    init {
        allData = repository.allData
        repository = HistoryRepo(application)
    }

    fun insert(historyModel: HistoryModel) = viewModelScope.launch {
        repository.insert(historyModel)
    }
    fun update(historyModel: HistoryModel) = viewModelScope.launch {
        repository.update(historyModel)
    }
    fun delete(historyModel: HistoryModel) = viewModelScope.launch {
        repository.delete(historyModel)
    }
    fun clearAllData() = viewModelScope.launch {
        repository.clearAllData()
    }

    fun getAllData(): LiveData<List<HistoryModel>>{
        return allData
    }

    fun getItemCount(): LiveData<Int>{
        return repository.historyCount
    }


}