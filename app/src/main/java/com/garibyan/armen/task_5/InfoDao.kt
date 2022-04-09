package com.garibyan.armen.task_5

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface InfoDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(infoModel: InfoModel)

    @Query("Select * from info_table order by id ASC")
    fun getAllInfo(): LiveData<List<InfoModel>>

    @Query("Select sum(running_distance) from info_table")
    fun getSumOfRunningDistance(): LiveData<Double>

    @Query("Select avg(running_distance) from info_table")
    fun getAverageRunningDistance(): LiveData<Double>

    @Query("Select avg(swimming_distance) from info_table")
    fun getAverageSwimmingDistance(): LiveData<Double>

    @Query("Select avg(taken_colories) from info_table")
    fun getAverageTakenColoriesDistance(): LiveData<Double>
}