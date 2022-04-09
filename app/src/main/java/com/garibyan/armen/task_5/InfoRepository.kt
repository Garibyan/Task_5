package com.garibyan.armen.task_5

import androidx.lifecycle.LiveData

class InfoRepository(private val infoDao: InfoDao) {

    val getAllInfo: LiveData<List<InfoModel>> = infoDao.getAllInfo()
    val getSumOfRunningDistance: LiveData<Double> = infoDao.getSumOfRunningDistance()
    val getAverageRunningDistance: LiveData<Double> = infoDao.getAverageRunningDistance()
    val getAverageSwimmingDistance: LiveData<Double> = infoDao.getAverageSwimmingDistance()
    val getAverageTakenColoriesDistance: LiveData<Double> = infoDao.getAverageTakenColoriesDistance()


    suspend fun insert(infoModel: InfoModel) {
        infoDao.insert(infoModel)
    }
}