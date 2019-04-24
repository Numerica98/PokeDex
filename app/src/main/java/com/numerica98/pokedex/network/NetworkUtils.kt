package com.numerica98.pokedex.network

import android.net.Uri
import android.util.Log
import java.io.IOException
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL
import java.util.*

class NetworkUtils {

    val POKEMON_API_BASEURL = "https://pokeapi.co/api/v2/"

    private val TAG = NetworkUtils::class.java.simpleName

    fun buildSearchUrl(root: String, pokemonID: String) : URL {
        val buildUri = Uri.parse(POKEMON_API_BASEURL)
            .buildUpon()
            .appendPath(root)
            .appendPath(pokemonID)
            .build()

        val url = try {
            URL(buildUri.toString())
        } catch (e: MalformedURLException) {
            URL("")
        }

        Log.d(TAG, "Built URI $url")

        return url
    }

    @Throws(IOException::class)
    fun getResponseFromHttpUrl(url: URL): String {
        val urlConnection = url.openConnection() as HttpURLConnection
        try {
            val `in` = urlConnection.inputStream

            val scanner = Scanner(`in`)
            scanner.useDelimiter("\\A")

            val hasInput = scanner.hasNext()
            return if (hasInput) {
                scanner.next()
            } else {
                ""
            }
        } finally {
            urlConnection.disconnect()
        }
    }
}
