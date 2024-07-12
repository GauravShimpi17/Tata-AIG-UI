package com.example.practice

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.practice.databinding.PosterImageBinding

class ImgRecyclerAdapter(private val dataList: List<String>) :
    RecyclerView.Adapter<ImgRecyclerAdapter.MyViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.poster_image2, parent, false)
        return MyViewHolder(view)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
    }
    override fun getItemCount(): Int {
        return dataList.size
    }
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}