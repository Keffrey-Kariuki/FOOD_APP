package com.example.foodapp.data.repository

import androidx.lifecycle.LiveData
import com.example.foodapp.data.db.dao.IngredientDao
import com.example.foodapp.data.model.IngredientModel
import com.example.foodapp.data.network.AppService

class IngredientRepository(private val appService: AppService, private val ingredientDao: IngredientDao) {

    suspend fun retrieveIngredientsFromNetAndStoreInDB(){
        // fetch from network
        val ingredients = appService.getIngredientsFromInternet()
        // loop through every ingredient in list
        ingredients.meals.forEach { ingItem ->
            val ingredient = IngredientModel(
                id = ingItem.idIngredient.toLong(),
                name = ingItem.strIngredient
            )
            // store ingredients in db
            ingredientDao.addIngredient(ingredient)
        }
    }


    fun createIngredientList() : LiveData<List<IngredientModel>> = ingredientDao.getIngredientsFromDB()

    suspend fun clearIngredients(){
        ingredientDao.deleteIngredientsFromDB()
    }

}