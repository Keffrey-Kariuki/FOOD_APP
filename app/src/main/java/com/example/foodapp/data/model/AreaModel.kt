package com.example.foodapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "area_table")
data class AreaModel(
    @PrimaryKey(autoGenerate = true)
    val id : Long,
    val name : String)
