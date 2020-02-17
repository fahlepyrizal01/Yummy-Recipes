package com.fahlepyrizal01.yummyrecipes.activity

import android.content.Intent
import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.fahlepyrizal01.yummyrecipes.R
import com.fahlepyrizal01.yummyrecipes.adapter.RecyclerViewRecipesAdapter
import com.fahlepyrizal01.yummyrecipes.model.Recipe
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), RecyclerViewRecipesAdapter.OnItemClickCallback {

    companion object {
        const val EXTRA_RECIPE = "extra_recipe"
    }

    private lateinit var dataPoster: TypedArray
    private lateinit var dataName: Array<String>
    private lateinit var dataDate: Array<String>
    private lateinit var dataYields: Array<String>
    private lateinit var dataPrepTime: Array<String>
    private lateinit var dataTotalTime: Array<String>
    private val recipes = ArrayList<Recipe>()
    private lateinit var ingredients: Array<String>
    private val dataIngredients = ArrayList<String>()
    private lateinit var directions: Array<String>
    private val dataDirections = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar.run {
            title = getString(R.string.app_name)
            setSupportActionBar(this)
        }

        getData()

        recyclerViewRecipes.setHasFixedSize(true)
        recyclerViewRecipes.layoutManager = LinearLayoutManager(this)
        val adapter = RecyclerViewRecipesAdapter(recipes)
        recyclerViewRecipes.adapter = adapter

        adapter.setOnItemClickCallback(this)
    }

    override fun onItemClicked(recipe: Recipe) {
        startActivity(Intent(this, RecipeDetailsActivity::class.java)
            .putExtra(EXTRA_RECIPE, recipe))
    }

    private fun getData() {
        dataPoster = resources.obtainTypedArray(R.array.data_poster)
        dataName = resources.getStringArray(R.array.data_name)
        dataDate = resources.getStringArray(R.array.data_date)
        dataYields = resources.getStringArray(R.array.data_yields)
        dataPrepTime = resources.getStringArray(R.array.data_prep_time)
        dataTotalTime = resources.getStringArray(R.array.data_total_time)

        for (position in dataName.indices) {
            val recipe = Recipe(
                dataPoster.getResourceId(position, -1),
                dataName[position],
                dataDate[position],
                dataYields[position],
                dataPrepTime[position],
                dataTotalTime[position],
                arrayListOf(),
                arrayListOf()
            )

            dataIngredients.clear()
            dataDirections.clear()
            when(position){
                0 -> {
                    ingredients = resources.getStringArray(R.array.data_ingredients_pink_senoritas)
                    directions = resources.getStringArray(R.array.data_directions_pink_senoritas)

                    for (i in ingredients.indices){ dataIngredients.add(ingredients[i]) }

                    for (i in directions.indices){ dataDirections.add(directions[i]) }

                    recipe.ingredients = dataIngredients
                    recipe.directions = dataDirections
                }
                1 -> {
                    ingredients = resources.getStringArray(R.array.data_ingredients_antipasto_stuffed_chicken)
                    directions = resources.getStringArray(R.array.data_directions_antipasto_stuffed_chicken)

                    for (i in ingredients.indices){ dataIngredients.add(ingredients[i]) }

                    for (i in directions.indices){ dataDirections.add(directions[i]) }

                    recipe.ingredients = dataIngredients
                    recipe.directions = dataDirections
                }
                2 -> {
                    ingredients = resources.getStringArray(R.array.data_ingredients_meat_egg_and_cheese_rollups)

                    directions = resources.getStringArray(R.array.data_directions_meat_egg_and_cheese_rollups)

                    for (i in ingredients.indices){ dataIngredients.add(ingredients[i]) }

                    for (i in directions.indices){ dataDirections.add(directions[i]) }

                    recipe.ingredients = dataIngredients
                    recipe.directions = dataDirections
                }
                3 -> {
                    ingredients = resources.getStringArray(R.array.data_ingredients_avocado_egg_boats)

                    directions = resources.getStringArray(R.array.data_directions_avocado_egg_boats)

                    for (i in ingredients.indices){ dataIngredients.add(ingredients[i]) }

                    for (i in directions.indices){ dataDirections.add(directions[i]) }

                    recipe.ingredients = dataIngredients
                    recipe.directions = dataDirections
                }
                4 -> {
                    ingredients = resources.getStringArray(R.array.data_ingredients_fluffy_vegan_pancakes)

                    directions = resources.getStringArray(R.array.data_directions_fluffy_vegan_pancakes)

                    for (i in ingredients.indices){ dataIngredients.add(ingredients[i]) }

                    for (i in directions.indices){ dataDirections.add(directions[i]) }

                    recipe.ingredients = dataIngredients
                    recipe.directions = dataDirections
                }
                5 -> {
                    ingredients = resources.getStringArray(R.array.data_ingredients_smashed_brussels_sprouts)

                    val directions = resources.getStringArray(R.array.data_directions_smashed_brussels_sprouts)

                    for (i in ingredients.indices){ dataIngredients.add(ingredients[i]) }

                    for (i in directions.indices){ dataDirections.add(directions[i]) }

                    recipe.ingredients = dataIngredients
                    recipe.directions = dataDirections
                }
                6 -> {
                    ingredients = resources.getStringArray(R.array.data_ingredients_red_wine_milkshakes)

                    directions = resources.getStringArray(R.array.data_directions_red_wine_milkshakes)

                    for (i in ingredients.indices){ dataIngredients.add(ingredients[i]) }

                    for (i in directions.indices){ dataDirections.add(directions[i]) }

                    recipe.ingredients = dataIngredients
                    recipe.directions = dataDirections
                }
                7 -> {
                    ingredients = resources.getStringArray(R.array.data_ingredients_french_onion_chicken_zoodle_bake)

                    directions = resources.getStringArray(R.array.data_directions_french_onion_chicken_zoodle_bake)

                    for (i in ingredients.indices){ dataIngredients.add(ingredients[i]) }

                    for (i in directions.indices){ dataDirections.add(directions[i]) }

                    recipe.ingredients = dataIngredients
                    recipe.directions = dataDirections
                }
                8 -> {
                    ingredients = resources.getStringArray(R.array.data_ingredients_deep_blue_vodka_punch)

                    directions = resources.getStringArray(R.array.data_directions_deep_blue_vodka_punch)

                    for (i in ingredients.indices){ dataIngredients.add(ingredients[i]) }

                    for (i in directions.indices){ dataDirections.add(directions[i]) }

                    recipe.ingredients = dataIngredients
                    recipe.directions = dataDirections
                }
                9 -> {
                    ingredients = resources.getStringArray(R.array.data_ingredients_cauli_shepherds_pie)

                    directions = resources.getStringArray(R.array.data_directions_cauli_shepherds_pie)

                    for (i in ingredients.indices){ dataIngredients.add(ingredients[i]) }

                    for (i in directions.indices){ dataDirections.add(directions[i]) }

                    recipe.ingredients = dataIngredients
                    recipe.directions = dataDirections
                }
            }

            recipes.add(recipe)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_setting) {
            startActivity(Intent(this, AboutActivity::class.java))
        }

        return super.onOptionsItemSelected(item)
    }
}
