package com.example.foodapp.fragments.lists.meals.meals_cat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.foodapp.databinding.FragmentCategoryMealBinding

class MealCategoryFragment : Fragment() {

    private lateinit var binding : FragmentCategoryMealBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentCategoryMealBinding.inflate(inflater, container, false)

        return binding.root
    }

}