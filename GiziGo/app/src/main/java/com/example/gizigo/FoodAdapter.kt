package com.example.gizigo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FoodAdapter(private val foodList: List<Food>, private val onAddClick: (Food) -> Unit) :
    RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {

    class FoodViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvName: TextView = view.findViewById(R.id.tv_food_name)
        val tvStats: TextView = view.findViewById(R.id.tv_food_stats)
        val btnAdd: Button = view.findViewById(R.id.btn_item_tambah)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_food, parent, false)
        return FoodViewHolder(view)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val food = foodList[position]
        holder.tvName.text = food.name
        holder.tvStats.text = food.stats
        holder.btnAdd.setOnClickListener { onAddClick(food) }
    }

    override fun getItemCount(): Int = foodList.size
}