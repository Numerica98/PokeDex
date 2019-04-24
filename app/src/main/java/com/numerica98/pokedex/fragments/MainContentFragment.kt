package com.numerica98.pokedex.fragments

import android.support.v4.app.Fragment
import com.numerica98.pokedex.models.Pokemon

class MainContentFragment: Fragment() {

    var pokemon = Pokemon()

    companion object {
        fun newInstance(pokemon: Pokemon): MainContentFragment{
            val newFragment = MainContentFragment()
            newFragment.pokemon = pokemon
            return  newFragment
        }
    }
}