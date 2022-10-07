package com.example.foodapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "meal_table")
data class MealModel(
    @PrimaryKey(autoGenerate = false)
    val id: Long,
    val name : String,
    val pic : String,
    val area: String?,
    val category : String?,
    val ing : String?)
