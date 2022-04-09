package com.garibyan.armen.task_5

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "info_table")
class InfoModel(
    @ColumnInfo(name = "running_distance") val runningDistance: Double,
    @ColumnInfo(name = "swimming_distance") val swimmingDistance: Double,
    @ColumnInfo(name = "taken_colories") val takenColories: Double
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}