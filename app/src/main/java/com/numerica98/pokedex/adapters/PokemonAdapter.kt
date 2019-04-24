package com.numerica98.pokedex.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.numerica98.pokedex.R
import com.numerica98.pokedex.models.Pokemon
import kotlinx.android.synthetic.main.list_element_pokemons.view.*

class PokemonAdapter (var pokemones: List<Pokemon>, val clickListener: (Pokemon) -> Unit): RecyclerView.Adapter<PokemonAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_element_pokemons, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = pokemones.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(pokemones[position], clickListener)


    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(item: Pokemon, clickListener: (Pokemon) -> Unit) = with(itemView) {
            tv_pokemon_id.text = item.id.toString()
            tv_pokemon_name.text = item.name
            tv_pokemon_type.text = item.type
            this.setOnClickListener { clickListener(item) }
        }
    }
}
