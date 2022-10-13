package com.example.foodapp.fragments.adapters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.foodapp.R
import com.example.foodapp.data.model.CategoryModel
import com.example.foodapp.databinding.SingleCategoryBinding

class CategoryAdapter : ListAdapter<CategoryModel, CategoryAdapter.CategoryViewHolder>(CategoryDiffUtil()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val currentCategory = currentList[position]
        holder.bindData(currentCategory)
        holder.binding.rowCategory.setOnClickListener {
            holder.transferData(currentCategory)
        }
    }

    class CategoryViewHolder(val binding : SingleCategoryBinding) : RecyclerView.ViewHolder(binding.root){
        fun bindData(category : CategoryModel){
            binding.category = category
            binding.executePendingBindings()
        }
        fun transferData(category: CategoryModel){
            val mealCategoryData = Bundle()
            mealCategoryData.putString(MEALCATEGORYNAME, category.name)
            binding.root.findNavController().navigate(R.id.action_categoryFragment_to_mealCategoryFragment, mealCategoryData)
        }
        companion object{
            fun from(parent : ViewGroup) : CategoryViewHolder{
                val inflater = LayoutInflater.from(parent.context)
                val binding = SingleCategoryBinding.inflate(inflater, parent, false)
                return CategoryViewHolder(binding)
            }
        }

    }

    companion object{
        const val MEALCATEGORYNAME = "name"
    }

}
class CategoryDiffUtil : DiffUtil.ItemCallback<CategoryModel>(){
    override fun areItemsTheSame(oldItem: CategoryModel, newItem: CategoryModel): Boolean = (oldItem.id == newItem.id)

    override fun areContentsTheSame(oldItem: CategoryModel, newItem: CategoryModel): Boolean = (oldItem == newItem)
}