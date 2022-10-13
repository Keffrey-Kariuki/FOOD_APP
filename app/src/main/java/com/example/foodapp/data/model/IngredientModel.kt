package com.example.foodapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ingredient_table")
data class IngredientModel(
    @PrimaryKey(autoGenerate = false)
    val id : Long,
    val name : String)
