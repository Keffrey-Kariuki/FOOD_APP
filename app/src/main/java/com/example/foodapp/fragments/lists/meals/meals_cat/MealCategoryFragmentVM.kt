package com.example.foodapp.fragments.lists.meals.meals_cat

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodapp.data.repository.MealRepository
import kotlinx.coroutines.launch

class MealCategoryFragmentVM(private val mealRepository: MealRepository, private val categoryFilter : String) : ViewModel() {

    val mealsByCategoryList = mealRepository.createMealListByCategory(categoryFilter)

    init {
        viewModelScope.launch {
            mealRepository.retrieveMealsByCategoryFromNetAndStoreInDB(categoryFilter)
        }
    }

}