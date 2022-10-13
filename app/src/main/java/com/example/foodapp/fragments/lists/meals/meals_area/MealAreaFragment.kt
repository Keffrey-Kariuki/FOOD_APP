package com.example.foodapp.fragments.lists.meals.meals_area

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
import com.example.foodapp.databinding.FragmentAreaMealBinding
import com.example.foodapp.fragments.adapters.AreaAdapter
import com.example.foodapp.fragments.adapters.MealAdapter

class MealAreaFragment : Fragment() {

    private lateinit var binding : FragmentAreaMealBinding
    private lateinit var appService: AppService
    private lateinit var appDB : AppDatabase
    private lateinit var mealDao: MealDao
    private lateinit var mealRepository: MealRepository
    private lateinit var mealAreaFragmentVM: MealAreaFragmentVM

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentAreaMealBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner

        createVM()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewmodel = mealAreaFragmentVM
        val adapter = MealAdapter()
        binding.rvMealArea.adapter = adapter
    }

    private fun createVM(){
        appService = RetrofitUtils.appService
        appDB = AppDatabase.getDatabase(requireContext())
        mealDao = appDB.mealDao()
        mealRepository = MealRepository(appService, mealDao)

        val areaFilter = requireArguments().getString(AreaAdapter.MEALAREANAME)
        mealAreaFragmentVM = areaFilter?.let { MealAreaFragmentVM(mealRepository, it) }!!
    }

}