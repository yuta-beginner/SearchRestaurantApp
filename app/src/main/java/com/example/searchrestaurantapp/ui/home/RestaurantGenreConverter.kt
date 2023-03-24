package com.example.searchrestaurantapp.ui.home



import android.content.Context
import android.util.Log
import androidx.databinding.InverseMethod
import com.example.searchrestaurantapp.R

object RestaurantGenreConverter {

    @InverseMethod("stringToCategory")
    @JvmStatic
    fun categoryToString(context: Context, categoryId: String): String {
        Log.d("categoryToString","categoryToString method starts")
        val restaurantGenreCodes: MutableList<String> = context.resources.getStringArray(R.array.restaurant_genre_codes).toMutableList()
        val restaurantGenres: MutableList<String> = context.resources.getStringArray(R.array.option_genre).toMutableList()
        var genreTextString: String = restaurantGenreCodes[0]
        Log.d("genreTextString", "initialized genreTextString is $genreTextString")
        Log.d("categoryId", "categoryId of categoryToString argument is $categoryId")

        // get index of restaurantGenreCodes which matches categoryId
        val categoryIdIndex = restaurantGenreCodes.indexOf(categoryId)
        // set selected genreTextString which is gotten from restaurantGenres[categoryIdIndex]
        genreTextString = restaurantGenres[categoryIdIndex]

        Log.d("categoryIdIndex", "categoryIdIndex is $categoryIdIndex")
        Log.d("genreTextString", "selected genreTextString is $genreTextString")
        Log.d("categoryToString","categoryToString method ends")
        return genreTextString
    }

    @JvmStatic
    fun stringToCategory(context: Context, restaurantGenre: String): String {
        Log.d("stringToCategory","stringToCategory method starts")

        val restaurantGenreCodes: MutableList<String> = context.resources.getStringArray(R.array.restaurant_genre_codes).toMutableList()
        val restaurantGenres: MutableList<String> = context.resources.getStringArray(R.array.option_genre).toMutableList()
        var categoryId: String = restaurantGenreCodes[0]

        Log.d("restaurantGenreString", "restaurantGenreString of stringToCategory argument is $restaurantGenre")
        Log.d("categoryId", "Initialized categoryId is $categoryId")

        // get index of restaurantGenres List which matches restaurantGenre
        val restaurantGenreIndex: Int = restaurantGenres.indexOf(restaurantGenre)
        // get restaurantGenreCode which index is restaurantGenreIndex
        categoryId = restaurantGenreCodes[restaurantGenreIndex]

        Log.d("restaurantGenreIndex", "restaurantGenreIndex is $restaurantGenreIndex")
        Log.d("categoryId", "selected categoryId is $categoryId")
        Log.d("stringToCategory","stringToCategory method ends")

        return categoryId
    }
}