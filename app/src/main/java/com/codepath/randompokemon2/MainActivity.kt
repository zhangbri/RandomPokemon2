package com.codepath.randompokemon2

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codepath.asynchttpclient.AsyncHttpClient
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler
import okhttp3.Headers
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var pokemonList: MutableList<Pokemon>
    private lateinit var rvPets: RecyclerView
    private lateinit var adapter: PetAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvPets = findViewById(R.id.pet_list)
        pokemonList = mutableListOf()
        adapter = PetAdapter(pokemonList) { pokemon ->
            Toast.makeText(this, "Clicked on ${pokemon.name}", Toast.LENGTH_SHORT).show()
        }

        rvPets.layoutManager = LinearLayoutManager(this)
        rvPets.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        rvPets.adapter = adapter

        fetchRandomPokemon()

        rvPets.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if (!recyclerView.canScrollVertically(1)) {
                    fetchRandomPokemon()
                }
            }
        })

        val searchView: SearchView = findViewById(R.id.search_view)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let {
                    fetchPokemonByName(it.trim())
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return true
            }
        })
    }

    private fun fetchRandomPokemon() {
        val pokemonId = Random.nextInt(1, 899)
        getPokemonData(pokemonId.toString())
    }

    private fun fetchPokemonByName(pokemonName: String) {
        getPokemonData(pokemonName)
    }

    private fun getPokemonData(pokemonName: String) {
        val client = AsyncHttpClient()
        client["https://pokeapi.co/api/v2/pokemon/$pokemonName", object : JsonHttpResponseHandler() {
            override fun onSuccess(statusCode: Int, headers: Headers, json: JsonHttpResponseHandler.JSON) {
                val name = json.jsonObject.getString("name")
                val imageUrl = json.jsonObject.getJSONObject("sprites").getString("front_default")
                val description = "Sample Description" // Replace with actual data from the API

                val newPokemon = Pokemon(imageUrl, name.capitalize(), description)
                pokemonList.add(newPokemon)

                runOnUiThread {
                    adapter.notifyItemInserted(pokemonList.size - 1)
                }
            }

            override fun onFailure(statusCode: Int, headers: Headers?, errorResponse: String, throwable: Throwable?) {
                Log.e("Pokemon Error", errorResponse, throwable)
            }
        }]
    }
}