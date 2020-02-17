package com.fahlepyrizal01.yummyrecipes.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager

import com.fahlepyrizal01.yummyrecipes.R
import com.fahlepyrizal01.yummyrecipes.adapter.RecyclerViewIngredientsDirectionsAdapter
import kotlinx.android.synthetic.main.fragment_recipe.*

class RecipeFragment : Fragment() {

    companion object {
        private const val ARG_INGREDIENT_DIRECTIONS = "ingredients_directions"
        fun newInstance(ingredientsDirections: ArrayList<String>): RecipeFragment {
            val fragment = RecipeFragment()
            val bundle = Bundle()
            bundle.putStringArrayList(ARG_INGREDIENT_DIRECTIONS, ingredientsDirections)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_recipe, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (arguments != null) {
            recyclerViewDetails.setHasFixedSize(true)
            recyclerViewDetails.layoutManager = LinearLayoutManager(context)
            recyclerViewDetails.adapter = RecyclerViewIngredientsDirectionsAdapter(arguments?.getStringArrayList(ARG_INGREDIENT_DIRECTIONS) as ArrayList<String>)

            Log.d("testing", (arguments?.getStringArrayList(ARG_INGREDIENT_DIRECTIONS) as ArrayList<String>)[0])
        }
    }
}
