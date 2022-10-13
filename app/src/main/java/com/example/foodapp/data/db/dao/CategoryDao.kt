package com.example.foodapp.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.foodapp.data.model.CategoryModel

@Dao
interface CategoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addCategory(category : CategoryModel)

    @Query("SELECT * FROM category_table")
    fun getCategoriesFromDB() : LiveData<List<CategoryModel>>

    @Query("DELETE FROM category_table")
    suspend fun deleteCategoriesFromDB()

}