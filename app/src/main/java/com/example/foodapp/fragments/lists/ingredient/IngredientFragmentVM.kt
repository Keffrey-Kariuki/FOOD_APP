package com.example.foodapp.fragments.lists.ingredient

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodapp.data.repository.IngredientRepository
import kotlinx.coroutines.launch

class IngredientFragmentVM(private val ingredientRepository: IngredientRepository) : ViewModel() {

    val ingredientList = ingredientRepository.createIngredientList()

    init {
        viewModelScope.launch {
            ingredientRepository.retrieveIngredientsFromNetAndStoreInDB()
        }
    }

}