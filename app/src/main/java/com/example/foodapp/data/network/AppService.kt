package com.example.foodapp.data.network

import com.example.foodapp.data.response.*
import retrofit2.http.GET
import retrofit2.http.Query

interface AppService {

    @GET("/api/json/v1/1/categories.php")
    suspend fun getCategoriesFromInternet() : CategoryListResponse

    @GET("/api/json/v1/1/list.php")
    suspend fun getIngredientsFromInternet(@Query("i") i : String = "list") : IngredientListResponse

    @GET("/api/json/v1/1/search.php")
    suspend fun getSearchFromInternet(@Query("s") s : String) : SearchListResponse

    @GET("/api/json/v1/1/list.php")
    suspend fun getAreasFromInternet(@Query("a") a : String = "list") : AreaListResponse

    @GET("/api/json/v1/1/filter.php")
    suspend fun getMealsFromInternetByArea(@Query("a") a : String) : MealListResponse

    @GET("/api/json/v1/1/filter.php")
    suspend fun getMealsFromInternetByCategory(@Query("c") c : String) : MealListResponse

    @GET("/api/json/v1/1/filter.php")
    suspend fun getMealsFromInternetByIngredient(@Query("i") i : String) : MealListResponse

}