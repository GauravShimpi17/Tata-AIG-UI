package com.example.practice


import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.practice.databinding.MenuItemsBinding


class MenuRecycler(
    private val menuGroups: List<NavigationMenuGroup>
) : RecyclerView.Adapter<MenuRecycler.MenuViewHolder>() {

//    private lateinit var onClick: (Int) -> Unit

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val binding = MenuItemsBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MenuViewHolder(binding)
    }

//    fun setOnClickListener(block: (Int) -> Unit) {
//        onClick = block
//    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        val menuGroup = menuGroups[position]
//        holder.binding.icon.setImageResource(menuGroup.icon)
        val drawableStart = ContextCompat.getDrawable(holder.itemView.context, menuGroup.icon)
        var drawableEnd: Drawable? = null

        holder.binding.text.text = menuGroup.text

        val subItemsAdapter = SubItemsAdapter(menuGroup.items)
        holder.binding.subItemsRecyclerView.adapter = subItemsAdapter
        holder.binding.subItemsRecyclerView.layoutManager =
            LinearLayoutManager(holder.itemView.context)


        if (menuGroup.items.isEmpty()) {
            holder.binding.subItemsRecyclerView.visibility = View.GONE
//            holder.binding.text.visibility = View.GONE
        } else {
            if (menuGroup.isExpanded) {
                holder.binding.subItemsRecyclerView.visibility = View.VISIBLE
                drawableEnd = ContextCompat.getDrawable(
                    holder.itemView.context,
                    R.drawable.baseline_keyboard_arrow_up_24
                ) // Up arrow
            } else {
                holder.binding.subItemsRecyclerView.visibility = View.GONE
                drawableEnd = ContextCompat.getDrawable(
                    holder.itemView.context,
                    R.drawable.baseline_keyboard_arrow_down_24
                ) // Down arrow
            }
        }
        holder.binding.text.setCompoundDrawablesRelativeWithIntrinsicBounds(
            drawableStart,
            null,
            drawableEnd,
            null
        )
    }

    override fun getItemCount(): Int = menuGroups.size

    inner class MenuViewHolder(val binding: MenuItemsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.text.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val menuGroup = menuGroups[position]
                    menuGroup.isExpanded = !menuGroup.isExpanded
                    notifyItemChanged(position)
                }
              /*  if (this@MenuRecycler::onClick.isInitialized){
                    onClick(position)
                }*/
            }
        }
    }
}