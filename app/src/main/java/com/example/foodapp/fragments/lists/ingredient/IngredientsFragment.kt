package com.example.foodapp.fragments.lists.ingredient

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.foodapp.data.db.AppDatabase
import com.example.foodapp.data.db.dao.IngredientDao
import com.example.foodapp.data.network.AppService
import com.example.foodapp.data.network.RetrofitUtils
import com.example.foodapp.data.repository.IngredientRepository
import com.example.foodapp.databinding.FragmentIngredientBinding
import com.example.foodapp.fragments.adapters.IngredientAdapter

class IngredientsFragment : Fragment() {

    private lateinit var binding : FragmentIngredientBinding
    private lateinit var appService: AppService
    private lateinit var appDB : AppDatabase
    private lateinit var ingredientDao: IngredientDao
    private lateinit var ingredientRepository: IngredientRepository
    private lateinit var ingredientFragmentVM: IngredientFragmentVM

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentIngredientBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner

        createVM()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewmodel = ingredientFragmentVM
        val adapter = IngredientAdapter()
        binding.rvIngredient.adapter = adapter
    }

    private fun createVM(){
        appService = RetrofitUtils.appService
        appDB = AppDatabase.getDatabase(requireContext())
        ingredientDao = appDB.ingredientDao()
        ingredientRepository = IngredientRepository(appService, ingredientDao)
        ingredientFragmentVM = IngredientFragmentVM(ingredientRepository)
    }

}