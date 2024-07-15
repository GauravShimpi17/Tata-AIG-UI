package com.example.practice

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.practice.databinding.MenuSubItemBinding

class SubItemsAdapter(
    private val items: List<String>
) : RecyclerView.Adapter<SubItemsAdapter.SubItemViewHolder>() {

    inner class SubItemViewHolder(val binding: MenuSubItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubItemViewHolder {
        val binding = MenuSubItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SubItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SubItemViewHolder, position: Int) {
        holder.binding.childItemNav.text = items[position]
    }

    override fun getItemCount(): Int = items.size
}
