package com.example.foodapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "category_table")
data class CategoryModel(
    @PrimaryKey(autoGenerate = false)
    val id : Long,
    val name : String,
    val pic : String)
