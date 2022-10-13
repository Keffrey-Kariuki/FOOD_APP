package com.example.foodapp.fragments.adapters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.foodapp.R
import com.example.foodapp.data.model.IngredientModel
import com.example.foodapp.databinding.SingleIngredientBinding

class IngredientAdapter : ListAdapter<IngredientModel, IngredientAdapter.IngredientViewHolder>(IngredientDiffUtil()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IngredientViewHolder {
        return IngredientViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: IngredientViewHolder, position: Int) {
        val currentIngredient = currentList[position]
        holder.bindData(currentIngredient)
        holder.binding.rowIngredient.setOnClickListener {
            holder.transferData(currentIngredient)
        }
    }

    class IngredientViewHolder(val binding : SingleIngredientBinding) : RecyclerView.ViewHolder(binding.root){
        fun bindData(ingredient : IngredientModel){
            binding.ingredient = ingredient
            binding.executePendingBindings()
        }
        fun transferData(ingredient: IngredientModel){
            val mealIngredientData = Bundle()
            mealIngredientData.putString(MEALINGREDIENTNAME, ingredient.name)
            binding.root.findNavController().navigate(R.id.action_ingredientsFragment_to_mealIngredientFragment, mealIngredientData)
        }
        companion object{
            fun from(parent : ViewGroup) : IngredientViewHolder{
                val inflater = LayoutInflater.from(parent.context)
                val binding = SingleIngredientBinding.inflate(inflater, parent, false)
                return IngredientViewHolder(binding)
            }
        }

    }

    companion object{
        const val MEALINGREDIENTNAME = "name"
    }

}
class IngredientDiffUtil : DiffUtil.ItemCallback<IngredientModel>(){
    override fun areItemsTheSame(oldItem: IngredientModel, newItem: IngredientModel): Boolean = (oldItem.id == newItem.id)

    override fun areContentsTheSame(oldItem: IngredientModel, newItem: IngredientModel): Boolean = (oldItem == newItem)
}