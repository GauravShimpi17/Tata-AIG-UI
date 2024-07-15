package com.example.practice

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.practice.databinding.CommonProgress2Binding

class MotorAdapter(private val motorData: List<String>) :
    RecyclerView.Adapter<MotorAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.common_progress2, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val drawable = ContextCompat.getDrawable(holder.itemView.context, R.drawable.not_eligible)
        holder.bind.apply {
            progressHeadline.text = "Motor Quarterly Campaign"
            centerImage.setImageResource(R.drawable.motor2)
            clubGold.visibility = View.GONE
            notEligible.text = "Not Eligible"
            notEligible.setCompoundDrawablesWithIntrinsicBounds(drawable, null, null, null);
        }
    }
    
    override fun getItemCount(): Int {
        return motorData.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val bind = CommonProgress2Binding.bind(itemView)
    }
}

