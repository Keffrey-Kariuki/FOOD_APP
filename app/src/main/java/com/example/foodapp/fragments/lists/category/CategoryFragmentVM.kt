package com.example.foodapp.fragments.lists.category

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodapp.data.repository.CategoryRepository
import kotlinx.coroutines.launch

class CategoryFragmentVM(private val categoryRepository: CategoryRepository) : ViewModel() {

    val categoryList = categoryRepository.createCategoriesList()

    init {
        viewModelScope.launch {
            categoryRepository.retrieveCategoriesFromNetAndStoreInDB()
        }
    }

}