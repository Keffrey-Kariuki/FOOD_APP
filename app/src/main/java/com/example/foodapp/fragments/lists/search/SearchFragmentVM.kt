package com.example.foodapp.fragments.lists.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodapp.data.db.dao.SearchDao
import com.example.foodapp.data.repository.SearchRepository
import kotlinx.coroutines.launch

class SearchFragmentVM(private val searchRepository: SearchRepository, private val searchDao: SearchDao) : ViewModel() {

    val latestSearch = searchRepository.createSearchList()
    val s: MutableLiveData<String> = MutableLiveData("")
    val isLoading: MutableLiveData<Boolean> = MutableLiveData(false)

    fun search(){
        viewModelScope.launch {
            toggleLoading()
            s.value?.let { s ->
                searchRepository.retrieveSearchResultsFromNet(s)
            }
            toggleLoading()
        }
    }

    fun delete(){
        viewModelScope.launch {
            searchDao.deleteSearchFromDB()
        }
    }

    private fun toggleLoading(){
        isLoading.value?.let { currentLoadingStatus ->
            isLoading.value = !currentLoadingStatus
        }
    }


}