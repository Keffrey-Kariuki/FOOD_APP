package com.example.foodapp.fragments.lists.ingredient

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.foodapp.databinding.FragmentIngredientBinding

class IngredientsFragment : Fragment() {

    private lateinit var binding : FragmentIngredientBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentIngredientBinding.inflate(inflater, container, false)

        return binding.root
    }

}