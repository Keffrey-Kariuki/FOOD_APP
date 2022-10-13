package com.example.foodapp.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.foodapp.data.model.IngredientModel

@Dao
interface IngredientDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addIngredient(ing : IngredientModel)

    @Query("SELECT * FROM ingredient_table")
    fun getIngredientsFromDB() : LiveData<List<IngredientModel>>

    @Query("DELETE FROM ingredient_table")
    suspend fun deleteIngredientsFromDB()

}