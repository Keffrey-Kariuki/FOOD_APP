package com.example.foodapp.fragments.lists.search

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.foodapp.databinding.FragmentDetailsSearchBinding
import com.example.foodapp.fragments.adapters.SearchAdapter
import com.example.foodapp.fragments.binders.setImage

class SearchDetailsFragment : Fragment() {

    private lateinit var binding : FragmentDetailsSearchBinding
    private lateinit var searchDetailsFragmentVM: SearchDetailsFragmentVM

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentDetailsSearchBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner

        createVM()
        createSearchItem()
        binding.tvSearchInstDetails.movementMethod = ScrollingMovementMethod()

        return binding.root
    }


    private fun createVM(){
        searchDetailsFragmentVM = SearchDetailsFragmentVM()
    }

    private fun createSearchItem(){
        val search_name = arguments?.getString(SearchAdapter.SEARCHNAME)
        val search_pic = arguments?.getString(SearchAdapter.SEARCHPIC)
        val search_inst = arguments?.getString(SearchAdapter.SEARCHINST)

        binding.ivSearchPicDetails.setImage(search_pic)
        binding.tvSearcNameDetails.setText(search_name)
        binding.tvSearchInstDetails.setText(search_inst)
    }


}