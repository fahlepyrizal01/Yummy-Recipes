package com.fahlepyrizal01.yummyrecipes.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fahlepyrizal01.yummyrecipes.R
import com.fahlepyrizal01.yummyrecipes.model.Recipe
import kotlinx.android.synthetic.main.item_recipe.view.*

class RecyclerViewRecipesAdapter(private val recipe: ArrayList<Recipe>) : RecyclerView.Adapter<RecyclerViewRecipesAdapter.ViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_recipe, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(recipe[position])
    }

    override fun getItemCount(): Int = recipe.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(recipe: Recipe) {
            with(itemView){
                Glide.with(context).load(recipe.poster).into(imageViewPoster)
                textViewName.text = recipe.name
                textViewDate.text = recipe.date
                textViewTotalTime.text = recipe.totalTime

                itemView.setOnClickListener {
                    onItemClickCallback.onItemClicked(recipe)
                }
            }
        }
    }

    interface OnItemClickCallback {
        fun onItemClicked (recipe: Recipe)
    }
}