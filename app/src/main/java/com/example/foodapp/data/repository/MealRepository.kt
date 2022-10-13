package com.example.foodapp.data.repository

import androidx.lifecycle.LiveData
import com.example.foodapp.data.db.dao.MealDao
import com.example.foodapp.data.model.MealModel
import com.example.foodapp.data.network.AppService

class MealRepository(private val appService: AppService, private val mealDao: MealDao) {

    suspend fun retrieveMealsByAreaFromNetAndStoreInDB(areaFilter : String){
        //fetch from network
        val mealsByAreaList = appService.getMealsFromInternetByArea(a = areaFilter)
        //loop through every meal
        mealsByAreaList.meals.forEach { mealItem ->
            val meal = MealModel(
                id = mealItem.idMeal.toLong(),
                name = mealItem.strMeal,
                pic = mealItem.strMealThumb,
                area = areaFilter,
                category = null,
                ing = null
            )
            mealDao.addMeal(meal)
        }

    }

    suspend fun retrieveMealsByCategoryFromNetAndStoreInDB(categoryFilter : String){
        //fetch from network
        val mealsByCategoryList = appService.getMealsFromInternetByCategory(c = categoryFilter)
        //loop through every meal
        mealsByCategoryList.meals.forEach { mealItem ->
            val meal = MealModel(
                id = mealItem.idMeal.toLong(),
                name = mealItem.strMeal,
                pic = mealItem.strMealThumb,
                area = null,
                category = categoryFilter,
                ing = null
            )
            mealDao.addMeal(meal)
        }

    }

    suspend fun retrieveMealsByIngredientsFromNetAndStoreInDB(ingFilter : String){
        //fetch from network
        val mealsByIngredientList = appService.getMealsFromInternetByIngredient(i = ingFilter)
        //loop through every meal
        mealsByIngredientList.meals.forEach { mealItem ->
            val meal = MealModel(
                id = mealItem.idMeal.toLong(),
                name = mealItem.strMeal,
                pic = mealItem.strMealThumb,
                area = null,
                category = null,
                ing = ingFilter
            )
            mealDao.addMeal(meal)
        }

    }

    fun createMealListByArea(areaFilter : String) : LiveData<List<MealModel>> = mealDao.getMealByAreaFromDB(areaFilter)
    fun createMealListByCategory(categoryFilter : String) : LiveData<List<MealModel>> = mealDao.getMealByCategoryFromDB(categoryFilter)
    fun createMealListByIngredient(ingFilter: String) : LiveData<List<MealModel>> = mealDao.getMealByIngredientFromDB(ingFilter)

    suspend fun clearMeals(){
        mealDao.deleteMealsFromDB()
    }

}