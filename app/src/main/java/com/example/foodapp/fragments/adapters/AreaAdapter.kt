package com.example.foodapp.fragments.adapters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.foodapp.R
import com.example.foodapp.data.model.AreaModel
import com.example.foodapp.data.model.CategoryModel
import com.example.foodapp.databinding.SingleAreaBinding

class AreaAdapter : ListAdapter<AreaModel, AreaAdapter.AreaViewHolder>(AreaDiffUtil()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AreaViewHolder {
        return AreaViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: AreaViewHolder, position: Int) {
        val currentArea = currentList[position]
        holder.bindData(currentArea)
        holder.binding.rowArea.setOnClickListener {
            holder.transferData(currentArea)
        }
    }

    class AreaViewHolder(val binding : SingleAreaBinding) : RecyclerView.ViewHolder(binding.root){
        fun bindData(area : AreaModel){
            binding.area = area
            binding.executePendingBindings()
        }
        fun transferData(area: AreaModel){
            val mealAreaData = Bundle()
            mealAreaData.putString(MEALAREANAME, area.name)
            binding.root.findNavController().navigate(R.id.action_areaFragment_to_mealAreaFragment, mealAreaData)
        }
        companion object{
            fun from(parent : ViewGroup) : AreaViewHolder{
                val inflater = LayoutInflater.from(parent.context)
                val binding = SingleAreaBinding.inflate(inflater, parent, false)
                return AreaViewHolder(binding)
            }
        }

    }

    companion object{
        const val MEALAREANAME = "name"
    }

}
class AreaDiffUtil : DiffUtil.ItemCallback<AreaModel>() {
    override fun areItemsTheSame(oldItem: AreaModel, newItem: AreaModel): Boolean = (oldItem.id == newItem.id)

    override fun areContentsTheSame(oldItem: AreaModel, newItem: AreaModel): Boolean = (oldItem == newItem)
}