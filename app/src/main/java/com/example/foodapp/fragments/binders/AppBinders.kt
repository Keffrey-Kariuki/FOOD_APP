package com.example.foodapp.fragments.binders

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.foodapp.data.model.*
import com.example.foodapp.fragments.adapters.*
import com.google.android.material.progressindicator.LinearProgressIndicator

@BindingAdapter("bindImage")
fun ImageView.setImage(url : String?){
    this.load(url)
}

@BindingAdapter("categoryBindList")
fun RecyclerView.setCategoryList(list : List<CategoryModel>?){
    (this.adapter as CategoryAdapter).submitList(list)
}

@BindingAdapter("ingredientBindList")
fun RecyclerView.setIngredientList(list : List<IngredientModel>?){
    (this.adapter as IngredientAdapter).submitList(list)
}

@BindingAdapter("searchBindList")
fun RecyclerView.setSearchList(list : List<SearchModel>?){
    (this.adapter as SearchAdapter).submitList(list)
}

@BindingAdapter("areaBindList")
fun RecyclerView.setAreaList(list : List<AreaModel>?){
    (this.adapter as AreaAdapter).submitList(list)
}

@BindingAdapter("mealAreaBindList")
fun RecyclerView.setMealAreaList(list : List<MealModel>?){
    (this.adapter as MealAdapter).submitList(list)
}

@BindingAdapter("mealCategoryBindList")
fun RecyclerView.setMealCategoryList(list : List<MealModel>?){
    (this.adapter as MealAdapter).submitList(list)
}

@BindingAdapter("mealIngBindList")
fun RecyclerView.setMealIngredientList(list : List<MealModel>?){
    (this.adapter as MealAdapter).submitList(list)
}


@BindingAdapter("isLoading")
fun LinearProgressIndicator.setLoading(loading: Boolean?){
    loading?.let { currentlyLoading ->
        this.visibility = if(currentlyLoading) View.VISIBLE else View.GONE
    }
}