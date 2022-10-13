package com.example.foodapp.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.foodapp.data.db.dao.*
import com.example.foodapp.data.model.*

@Database(entities = [MealModel::class, CategoryModel::class, IngredientModel::class, SearchModel::class, AreaModel::class], version = 4, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun mealDao() : MealDao
    abstract fun categoryDao() : CategoryDao
    abstract fun ingredientDao() : IngredientDao
    abstract fun searchDao() : SearchDao
    abstract fun areaDao() : AreaDao

    companion object{
        @Volatile
        private var INSTANCE : AppDatabase? = null

        fun getDatabase(context: Context) : AppDatabase{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database",
                ).fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}