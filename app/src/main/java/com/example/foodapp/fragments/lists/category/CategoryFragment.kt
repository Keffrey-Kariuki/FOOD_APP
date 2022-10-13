package com.example.foodapp.fragments.lists.category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.foodapp.data.db.AppDatabase
import com.example.foodapp.data.db.dao.CategoryDao
import com.example.foodapp.data.network.AppService
import com.example.foodapp.data.network.RetrofitUtils
import com.example.foodapp.data.repository.CategoryRepository
import com.example.foodapp.databinding.FragmentCategoryBinding
import com.example.foodapp.fragments.adapters.CategoryAdapter

class CategoryFragment : Fragment(){

    private lateinit var binding : FragmentCategoryBinding
    private lateinit var appService: AppService
    private lateinit var appDB : AppDatabase
    private lateinit var categoryDao: CategoryDao
    private lateinit var categoryRepository: CategoryRepository
    private lateinit var categoryFragmentVM: CategoryFragmentVM

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentCategoryBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner

        createVM()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewmodel = categoryFragmentVM
        val adapter = CategoryAdapter()
        binding.rvCategory.adapter = adapter
    }

    private fun createVM(){
        appService = RetrofitUtils.appService
        appDB = AppDatabase.getDatabase(requireContext())
        categoryDao = appDB.categoryDao()
        categoryRepository = CategoryRepository(appService, categoryDao)
        categoryFragmentVM = CategoryFragmentVM(categoryRepository)
    }

}