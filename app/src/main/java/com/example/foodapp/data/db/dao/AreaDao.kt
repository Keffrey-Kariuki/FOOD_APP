package com.example.foodapp.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.foodapp.data.model.AreaModel

@Dao
interface AreaDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addArea(area : AreaModel)

    @Query("SELECT * FROM area_table")
    fun getAreasFromDB() : LiveData<List<AreaModel>>

    @Query("DELETE FROM area_table")
    suspend fun deleteAreasFromDB()

}