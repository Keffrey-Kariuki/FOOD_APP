package com.example.foodapp.fragments.lists.search

import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import com.example.foodapp.R
import com.example.foodapp.data.db.AppDatabase
import com.example.foodapp.data.db.dao.SearchDao
import com.example.foodapp.data.network.AppService
import com.example.foodapp.data.network.RetrofitUtils
import com.example.foodapp.data.repository.SearchRepository
import com.example.foodapp.databinding.FragmentSearchBinding
import com.example.foodapp.fragments.adapters.SearchAdapter

class SearchFragment : Fragment() {

    private lateinit var binding : FragmentSearchBinding
    private lateinit var appService: AppService
    private lateinit var appDB : AppDatabase
    private lateinit var searchDao: SearchDao
    private lateinit var searchRepository: SearchRepository
    private lateinit var searchFragmentVM: SearchFragmentVM

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner


        createVM()
        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.toolbar_menu, menu)
        val searchItem = menu.findItem(R.id.menu_search)
        val searchView = searchItem.actionView as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let { searchQuery ->
                    searchFragmentVM.delete()
                    searchFragmentVM.s.value = searchQuery
                    searchFragmentVM.search()
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return true
            }
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewmodel = searchFragmentVM
        val adapter = SearchAdapter()
        binding.rvSearch.adapter = adapter
    }

    private fun createVM(){
        appService = RetrofitUtils.appService
        appDB = AppDatabase.getDatabase(requireContext())
        searchDao = appDB.searchDao()
        searchRepository = SearchRepository(appService, searchDao)
        searchFragmentVM = SearchFragmentVM(searchRepository, searchDao)
    }

}