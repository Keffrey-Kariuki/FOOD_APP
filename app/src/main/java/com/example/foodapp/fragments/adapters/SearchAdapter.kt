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
import com.example.foodapp.data.model.SearchModel
import com.example.foodapp.databinding.SingleIngredientBinding
import com.example.foodapp.databinding.SingleSearchBinding

class SearchAdapter : ListAdapter<SearchModel, SearchAdapter.SearchViewHolder>(SearchDiffUtil()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : SearchViewHolder {
        return SearchViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        val currentSearch = currentList[position]
        holder.bindData(currentSearch)
        val row = holder.binding.rowSearch
        row.setOnClickListener {
            holder.transferData(currentSearch)
        }
    }

    class SearchViewHolder(val binding : SingleSearchBinding) : RecyclerView.ViewHolder(binding.root){

        fun bindData(search : SearchModel){
            binding.search = search
            binding.executePendingBindings()
        }
        fun transferData(search : SearchModel){
            val searchDataBundle = Bundle()
            searchDataBundle.putString(SEARCHNAME, search.name)
            searchDataBundle.putString(SEARCHPIC, search.pic)
            searchDataBundle.putString(SEARCHINST, search.instructions)
            binding.root.findNavController().navigate(R.id.action_searchFragment_to_searchDetailsFragment, searchDataBundle)
        }
        companion object{
            fun from(parent : ViewGroup) : SearchViewHolder{
                val inflater = LayoutInflater.from(parent.context)
                val binding = SingleSearchBinding.inflate(inflater, parent, false)
                return SearchViewHolder(binding)
            }
        }

    }

    companion object{
        const val SEARCHNAME = "name"
        const val SEARCHPIC = "pic"
        const val SEARCHINST = "inst"
    }

}
class SearchDiffUtil : DiffUtil.ItemCallback<SearchModel>(){
    override fun areItemsTheSame(oldItem: SearchModel, newItem: SearchModel): Boolean = (oldItem.id == newItem.id)

    override fun areContentsTheSame(oldItem: SearchModel, newItem: SearchModel): Boolean = (oldItem == newItem)
}