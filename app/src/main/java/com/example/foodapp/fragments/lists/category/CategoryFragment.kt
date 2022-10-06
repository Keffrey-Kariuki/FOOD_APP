package com.example.foodapp.fragments.lists.category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.foodapp.databinding.FragmentCategoryBinding

class CategoryFragment : Fragment(){

    private lateinit var binding : FragmentCategoryBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentCategoryBinding.inflate(inflater, container, false)

        return binding.root
    }

}