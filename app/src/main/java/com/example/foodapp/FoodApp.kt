package com.example.foodapp

import android.app.Application
import androidx.work.*
import com.example.foodapp.data.worker.DeleteDBWorker
import java.util.concurrent.TimeUnit

class FoodApp : Application() {

    override fun onCreate() {
        super.onCreate()
        setUpWorkers()
    }

    private fun setUpWorkers(){
        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .setRequiresBatteryNotLow(true)
            .build()

        val deleteDBRequest = PeriodicWorkRequestBuilder<DeleteDBWorker>(1, TimeUnit.DAYS)
            .setConstraints(constraints)
            .build()

        WorkManager.getInstance(this).enqueueUniquePeriodicWork("delete_db", ExistingPeriodicWorkPolicy.REPLACE, deleteDBRequest)
    }

}