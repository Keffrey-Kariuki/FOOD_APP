package com.example.foodapp.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.foodapp.data.model.MealModel

@Dao
interface MealDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addMeal(meal : MealModel)

    @Query("SELECT * FROM meal_table WHERE area = :areaFilter")
    fun getMealByAreaFromDB(areaFilter : String) : LiveData<List<MealModel>>

    @Query("SELECT * FROM meal_table WHERE category = :categoryFilter")
    fun getMealByCategoryFromDB(categoryFilter : String) : LiveData<List<MealModel>>

    @Query("SELECT * FROM meal_table WHERE ing =:ingFilter")
    fun getMealByIngredientFromDB(ingFilter : String) : LiveData<List<MealModel>>

}