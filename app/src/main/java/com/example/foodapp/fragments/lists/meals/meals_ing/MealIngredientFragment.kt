package com.example.foodapp.fragments.lists.meals.meals_ing

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.foodapp.databinding.FragmentIngredientMealBinding

class MealIngredientFragment : Fragment() {

    private lateinit var binding : FragmentIngredientMealBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentIngredientMealBinding.inflate(inflater, container, false)

        return binding.root
    }

}