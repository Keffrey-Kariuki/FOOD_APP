package com.example.foodapp.fragments.lists.meals.meals_cat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.foodapp.data.db.AppDatabase
import com.example.foodapp.data.db.dao.MealDao
import com.example.foodapp.data.network.AppService
import com.example.foodapp.data.network.RetrofitUtils
import com.example.foodapp.data.repository.MealRepository
import com.example.foodapp.databinding.FragmentCategoryMealBinding
import com.example.foodapp.fragments.adapters.CategoryAdapter
import com.example.foodapp.fragments.adapters.MealAdapter

class MealCategoryFragment : Fragment() {

    private lateinit var binding : FragmentCategoryMealBinding
    private lateinit var appService: AppService
    private lateinit var appDB : AppDatabase
    private lateinit var mealDao: MealDao
    private lateinit var mealRepository: MealRepository
    private lateinit var mealCategoryFragmentVM: MealCategoryFragmentVM

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentCategoryMealBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner

        createVM()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewmodel = mealCategoryFragmentVM
        val adapter = MealAdapter()
        binding.rvMealCategory.adapter = adapter
    }

    private fun createVM(){
        appService = RetrofitUtils.appService
        appDB = AppDatabase.getDatabase(requireContext())
        mealDao = appDB.mealDao()
        mealRepository = MealRepository(appService, mealDao)

        val categoryFilter = requireArguments().getString(CategoryAdapter.MEALCATEGORYNAME)
        mealCategoryFragmentVM = categoryFilter?.let { MealCategoryFragmentVM(mealRepository, it) }!!
    }

}