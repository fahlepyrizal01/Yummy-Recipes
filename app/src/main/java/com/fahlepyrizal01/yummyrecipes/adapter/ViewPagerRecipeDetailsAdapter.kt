package com.fahlepyrizal01.yummyrecipes.adapter

import android.content.Context
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.fahlepyrizal01.yummyrecipes.R
import com.fahlepyrizal01.yummyrecipes.fragment.RecipeFragment
import com.fahlepyrizal01.yummyrecipes.model.Recipe

class ViewPagerRecipeDetailsAdapter(private val context: Context, private val recipe: Recipe, fm: FragmentManager) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    @StringRes
    private val tabTitles = intArrayOf(R.string.text_ingredients, R.string.text_directions)

    override fun getItem(position: Int): Fragment {
        return RecipeFragment.newInstance(if (position == 0) recipe.ingredients else recipe.directions)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(tabTitles[position])
    }

    override fun getCount(): Int = tabTitles.size
}