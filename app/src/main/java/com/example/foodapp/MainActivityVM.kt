package com.example.foodapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodapp.data.db.dao.SearchDao
import kotlinx.coroutines.launch

class MainActivityVM(private val searchDao: SearchDao) : ViewModel() {

    fun delete(){
        viewModelScope.launch {
            searchDao.deleteSearchFromDB()
        }
    }


}