package com.example.foodapp.data.repository

import androidx.lifecycle.LiveData
import com.example.foodapp.data.db.dao.CategoryDao
import com.example.foodapp.data.model.CategoryModel
import com.example.foodapp.data.network.AppService

class CategoryRepository(private val appService: AppService, private val categoryDao: CategoryDao) {

    suspend fun retrieveCategoriesFromNetAndStoreInDB(){
        // fetch from network
        val categories = appService.getCategoriesFromInternet()
        // loop through every category in list
        categories.categories.forEach { categoryItem ->
            val category = CategoryModel(
                id = categoryItem.idCategory.toLong(),
                name = categoryItem.strCategory,
                pic = categoryItem.strCategoryThumb
            )
            // store categories in db
            categoryDao.addCategory(category)
        }
    }

    fun createCategoriesList() : LiveData<List<CategoryModel>> = categoryDao.getCategoriesFromDB()

    suspend fun clearCategories(){
        categoryDao.deleteCategoriesFromDB()
    }

}