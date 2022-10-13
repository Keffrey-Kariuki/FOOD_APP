package com.example.foodapp.fragments.lists.meals.meals_ing

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodapp.data.repository.MealRepository
import kotlinx.coroutines.launch

class MealIngredientFragmentVM(private val mealRepository: MealRepository, private val ingFilter : String) : ViewModel() {


    val mealListByIngredient = mealRepository.createMealListByIngredient(ingFilter)

    init {
        viewModelScope.launch {
            mealRepository.retrieveMealsByIngredientsFromNetAndStoreInDB(ingFilter)
        }
    }

}