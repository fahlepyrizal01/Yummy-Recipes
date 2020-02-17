package com.fahlepyrizal01.yummyrecipes.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fahlepyrizal01.yummyrecipes.R
import kotlinx.android.synthetic.main.item_ingredients_directions.view.*

class RecyclerViewIngredientsDirectionsAdapter(private val ingredientsDirections: ArrayList<String>) : RecyclerView.Adapter<RecyclerViewIngredientsDirectionsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_ingredients_directions, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(ingredientsDirections[position], position)
    }

    override fun getItemCount(): Int = ingredientsDirections.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(value: String, position: Int) {
            with(itemView){
                val number = "${position+1}."
                textViewNumber.text = number
                textViewValue.text = value
            }
        }
    }
}