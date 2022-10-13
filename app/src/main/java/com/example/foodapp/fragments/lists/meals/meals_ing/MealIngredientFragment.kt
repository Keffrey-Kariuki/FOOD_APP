package com.example.foodapp.fragments.lists.meals.meals_ing

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
import com.example.foodapp.databinding.FragmentIngredientMealBinding
import com.example.foodapp.fragments.adapters.IngredientAdapter
import com.example.foodapp.fragments.adapters.MealAdapter

class MealIngredientFragment : Fragment() {

    private lateinit var binding : FragmentIngredientMealBinding
    private lateinit var appService: AppService
    private lateinit var appDB : AppDatabase
    private lateinit var mealDao: MealDao
    private lateinit var mealRepository: MealRepository
    private lateinit var mealIngredientFragmentVM: MealIngredientFragmentVM

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentIngredientMealBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner

        createVM()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewmodel = mealIngredientFragmentVM
        val adapter = MealAdapter()
        binding.rvMealIngredient.adapter = adapter
    }

    private fun createVM(){
        appService = RetrofitUtils.appService
        appDB = AppDatabase.getDatabase(requireContext())
        mealDao = appDB.mealDao()
        mealRepository = MealRepository(appService, mealDao)
        val ingFilter = requireArguments().getString(IngredientAdapter.MEALINGREDIENTNAME)

        mealIngredientFragmentVM = ingFilter?.let { MealIngredientFragmentVM(mealRepository, it) }!!
    }

}