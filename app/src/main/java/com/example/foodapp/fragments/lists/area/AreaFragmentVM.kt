package com.example.foodapp.fragments.lists.area

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodapp.data.repository.AreaRepository
import kotlinx.coroutines.launch

class AreaFragmentVM(private val areaRepository: AreaRepository) : ViewModel() {

    val areaList = areaRepository.createAreaList()


    init {
        viewModelScope.launch {
            areaRepository.retrieveAreasFromNetAndStoreInDB()
        }
    }


}