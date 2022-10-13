package com.example.foodapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.foodapp.data.db.AppDatabase
import com.example.foodapp.data.db.dao.SearchDao
import com.example.foodapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var appDB : AppDatabase
    private lateinit var searchDao: SearchDao
    private lateinit var mainActivityVM: MainActivityVM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fcvMain) as NavHostFragment
        val navController = navHostFragment.navController
        binding.bnvMain?.setupWithNavController(navController)
        binding.navigationRail?.setupWithNavController(navController)

        createVM()
    }

    private fun createVM() {
        appDB = AppDatabase.getDatabase(applicationContext)
        searchDao = appDB.searchDao()
        mainActivityVM = MainActivityVM(searchDao)
    }

    override fun onPause() {
        super.onPause()
        mainActivityVM.delete()
    }

}