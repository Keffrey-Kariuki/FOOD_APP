package com.example.foodapp.fragments.lists.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.foodapp.databinding.FragmentDetailsSearchBinding

class SearchDetailsFragment : Fragment() {

    private lateinit var binding : FragmentDetailsSearchBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentDetailsSearchBinding.inflate(inflater, container, false)

        return binding.root
    }


}