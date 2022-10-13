package com.example.foodapp.data.worker

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.foodapp.data.db.AppDatabase
import com.example.foodapp.data.network.RetrofitUtils
import com.example.foodapp.data.repository.*

class DeleteDBWorker(applicationContext : Context, workerParameters: WorkerParameters) : CoroutineWorker (applicationContext, workerParameters){

    override suspend fun doWork(): Result {
        return try {
            clearDB()
            Result.success()
        }catch (e: Exception){
            Result.retry()
            Result.failure()
        }
    }

    private suspend fun clearDB(){
        val appService = RetrofitUtils.appService
        val appDB = AppDatabase.getDatabase(applicationContext)

        val areaRepo = AreaRepository(appService, appDB.areaDao())
        areaRepo.clearAreas()

        val categoryRepo = CategoryRepository(appService, appDB.categoryDao())
        categoryRepo.clearCategories()

        val ingRepo = IngredientRepository(appService, appDB.ingredientDao())
        ingRepo.clearIngredients()

        val mealRepo = MealRepository(appService, appDB.mealDao())
        mealRepo.clearMeals()

        val searchRepo = SearchRepository(appService, appDB.searchDao())
        searchRepo.clearSearchList()
    }

}