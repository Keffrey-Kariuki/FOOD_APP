package com.example.foodapp.data.repository

import androidx.lifecycle.LiveData
import com.example.foodapp.data.db.dao.SearchDao
import com.example.foodapp.data.model.SearchModel
import com.example.foodapp.data.network.AppService

class SearchRepository(private val appService: AppService, private val searchDao: SearchDao) {


    suspend fun retrieveSearchResultsFromNet(s : String){
        //fetch from network
        val searched = appService.getSearchFromInternet(s = s)
        //loop through every item
        searched.meals?.forEach { searchItem ->
            val search = SearchModel(
                id = searchItem.idMeal.toLong(),
                name = searchItem.strMeal,
                pic = searchItem.strMealThumb,
                instructions = searchItem.strInstructions
            )
            searchDao.addSearch(search)
        }
    }

    fun createSearchList() : LiveData<List<SearchModel>> = searchDao.getSearchFromDB()

    suspend fun clearSearchList(){
        searchDao.deleteSearchFromDB()
    }

}