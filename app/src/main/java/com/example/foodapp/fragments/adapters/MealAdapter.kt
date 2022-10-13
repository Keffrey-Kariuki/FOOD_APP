package com.example.foodapp.fragments.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.foodapp.data.model.IngredientModel
import com.example.foodapp.data.model.MealModel
import com.example.foodapp.databinding.SingleIngredientBinding
import com.example.foodapp.databinding.SingleMealBinding

class MealAdapter : ListAdapter<MealModel, MealAdapter.MealViewHolder>(MealDiffUtil()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealViewHolder {
        return MealViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: MealViewHolder, position: Int) {
        val currentMeal = currentList[position]
        holder.bindData(currentMeal)
    }

    class MealViewHolder(private val binding : SingleMealBinding) : RecyclerView.ViewHolder(binding.root){
        fun bindData(meal : MealModel){
            binding.meal = meal
            binding.executePendingBindings()
        }
        companion object{
            fun from(parent : ViewGroup) : MealViewHolder{
                val inflater = LayoutInflater.from(parent.context)
                val binding = SingleMealBinding.inflate(inflater, parent, false)
                return MealViewHolder(binding)
            }
        }

    }

}
class MealDiffUtil : DiffUtil.ItemCallback<MealModel>(){
    override fun areItemsTheSame(oldItem: MealModel, newItem: MealModel): Boolean = (oldItem.id == newItem.id)

    override fun areContentsTheSame(oldItem: MealModel, newItem: MealModel): Boolean = (oldItem == newItem)
}