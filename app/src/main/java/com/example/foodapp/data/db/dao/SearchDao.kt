package com.example.foodapp.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.foodapp.data.model.SearchModel

@Dao
interface SearchDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addSearch(search : SearchModel)

    @Query("SELECT * FROM search_table")
    fun getSearchFromDB() : LiveData<List<SearchModel>>

    @Query("DELETE FROM search_table")
    suspend fun deleteSearchFromDB()

}