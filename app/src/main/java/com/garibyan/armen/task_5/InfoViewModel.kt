package com.garibyan.armen.task_5

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class InfoViewModel(application: Application) : AndroidViewModel(application) {

    val getAllInfo: LiveData<List<InfoModel>>
    val getSumOfRunningDistance: LiveData<Double>
    val getAverageRunningDistance: LiveData<Double>
    val getAverageSwimmingDistance: LiveData<Double>
    val getAverageTakenColoriesDistance: LiveData<Double>
    val repository: InfoRepository

    init {
        val dao = AppDatabase.getDatabase(application).getInfoDao()
        repository = InfoRepository(dao)
        getAllInfo = repository.getAllInfo
        getSumOfRunningDistance = repository.getSumOfRunningDistance
        getAverageRunningDistance = repository.getAverageRunningDistance
        getAverageSwimmingDistance = repository.getAverageSwimmingDistance
        getAverageTakenColoriesDistance = repository.getAverageTakenColoriesDistance
    }

    fun addInfo(infoModel: InfoModel) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(infoModel)
    }
}