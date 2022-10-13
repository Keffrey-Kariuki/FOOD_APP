package com.example.foodapp.fragments.lists.area

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.foodapp.data.db.AppDatabase
import com.example.foodapp.data.db.dao.AreaDao
import com.example.foodapp.data.network.AppService
import com.example.foodapp.data.network.RetrofitUtils
import com.example.foodapp.data.repository.AreaRepository
import com.example.foodapp.databinding.FragmentAreaBinding
import com.example.foodapp.fragments.adapters.AreaAdapter

class AreaFragment : Fragment() {

    private lateinit var binding : FragmentAreaBinding
    private lateinit var appService: AppService
    private lateinit var appDB : AppDatabase
    private lateinit var areaDao: AreaDao
    private lateinit var areaRepository: AreaRepository
    private lateinit var areaFragmentVM: AreaFragmentVM

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentAreaBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner

        createVM()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewmodel = areaFragmentVM
        val adapter = AreaAdapter()
        binding.rvArea.adapter = adapter
    }

    private fun createVM(){
        appService = RetrofitUtils.appService
        appDB = AppDatabase.getDatabase(requireContext())
        areaDao = appDB.areaDao()
        areaRepository = AreaRepository(appService, areaDao)
        areaFragmentVM = AreaFragmentVM(areaRepository)
    }

}