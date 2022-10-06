package com.example.foodapp.fragments.lists.area

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.foodapp.databinding.FragmentAreaBinding

class AreaFragment : Fragment() {

    private lateinit var binding : FragmentAreaBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentAreaBinding.inflate(inflater, container, false)

        return binding.root
    }


}