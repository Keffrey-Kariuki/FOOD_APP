package com.example.foodapp.data.repository

import androidx.lifecycle.LiveData
import com.example.foodapp.R
import com.example.foodapp.data.db.dao.AreaDao
import com.example.foodapp.data.model.AreaModel
import com.example.foodapp.data.network.AppService

class AreaRepository(private val appService: AppService, private val areaDao: AreaDao) {

    suspend fun retrieveAreasFromNetAndStoreInDB(){
        //fetch from network
        val areas = appService.getAreasFromInternet()
        //loop through every item
        areas.meals.forEach { areaItem ->
            val area = AreaModel(
                id = 0,
                name = areaItem.strArea,
            )
            areaDao.addArea(area)
        }
    }

    fun createAreaList() : LiveData<List<AreaModel>> = areaDao.getAreasFromDB()

    suspend fun clearAreas(){
        areaDao.deleteAreasFromDB()
    }

}