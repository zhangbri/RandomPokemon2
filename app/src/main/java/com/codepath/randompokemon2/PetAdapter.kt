package com.codepath.randompokemon2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

data class Pokemon(
    val imageUrl: String,
    val name: String,
    val description: String // Ensure you have a field for the description.
)

class PetAdapter(
    private val pokemonList: List<Pokemon>,
    private val onClick: (Pokemon) -> Unit
) : RecyclerView.Adapter<PetAdapter.ViewHolder>() {

    class ViewHolder(view: View, clickAtPosition: (Int) -> Unit) : RecyclerView.ViewHolder(view) {
        val petImage: ImageView = view.findViewById(R.id.pet_image)
        val petName: TextView = view.findViewById(R.id.pet_name)
        val petDescription: TextView = view.findViewById(R.id.pet_description)

        init {
            view.setOnClickListener {
                clickAtPosition(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pet_item, parent, false)
        // The lambda passed here will be executed when the ViewHolder's item view is clicked
        return ViewHolder(view) { position ->
            // Check if position is valid
            if (position != RecyclerView.NO_POSITION) {
                val pokemon = pokemonList[position]
                onClick(pokemon)
            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pokemon = pokemonList[position]
        Glide.with(holder.itemView.context)
            .load(pokemon.imageUrl)
            .centerCrop()
            .into(holder.petImage)
        holder.petName.text = pokemon.name
        holder.petDescription.text = pokemon.description
    }

    override fun getItemCount() = pokemonList.size
}