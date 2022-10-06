package com.example.foodapp.fragments.lists.meals.meals_area

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.foodapp.databinding.FragmentAreaMealBinding

class MealAreaFragment : Fragment() {

    private lateinit var binding : FragmentAreaMealBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentAreaMealBinding.inflate(inflater, container, false)

        return binding.root
    }

}