package com.example.foodapp.fragments.lists.meals.meals_area

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodapp.data.model.MealModel
import com.example.foodapp.data.repository.MealRepository
import kotlinx.coroutines.launch

class MealAreaFragmentVM(private val mealRepository: MealRepository, private val areaFilter : String) : ViewModel() {

    val mealsByAreaList = mealRepository.createMealListByArea(areaFilter)

    init {
        viewModelScope.launch {
            mealRepository.retrieveMealsByAreaFromNetAndStoreInDB(areaFilter)
        }
    }

}