package com.example.foodapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "search_table")
data class SearchModel(
    @PrimaryKey(autoGenerate = false)
    val id : Long,
    val name : String?,
    val pic : String?,
    val instructions : String?)
