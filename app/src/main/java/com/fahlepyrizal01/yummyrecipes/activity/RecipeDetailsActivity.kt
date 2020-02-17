package com.fahlepyrizal01.yummyrecipes.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.fahlepyrizal01.yummyrecipes.R
import com.fahlepyrizal01.yummyrecipes.adapter.ViewPagerRecipeDetailsAdapter
import com.fahlepyrizal01.yummyrecipes.model.Recipe
import kotlinx.android.synthetic.main.activity_recipe_details.*

class RecipeDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_details)

        toolbarDetails.run {
            title = resources.getString(R.string.text_details)
            setNavigationIcon(R.drawable.ic_arrow_back)
            setNavigationOnClickListener { finish() }
        }

       if (intent.hasExtra(MainActivity.EXTRA_RECIPE)){
           val recipe = intent.getParcelableExtra(MainActivity.EXTRA_RECIPE) as Recipe
           Glide.with(this).load(recipe.poster).into(imageViewPosterDetails)
           textViewNameDetails.text = recipe.name
           textViewDateDetailsValue.text = recipe.date
           textViewYieldsDetailsValue.text = recipe.yields
           textViewPrepTimeDetailsValue.text = recipe.prepTime
           textViewTotalTimeDetailsValue.text = recipe.totalTime

           viewPager.adapter = ViewPagerRecipeDetailsAdapter(this, recipe, supportFragmentManager)
           tabLayout.setupWithViewPager(viewPager)
           supportActionBar?.elevation = 0f
       }
    }
}
