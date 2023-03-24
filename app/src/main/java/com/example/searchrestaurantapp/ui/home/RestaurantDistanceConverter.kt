package com.example.searchrestaurantapp.ui.home

import android.content.Context
import android.util.Log
import android.widget.RadioGroup
import androidx.core.view.children
import androidx.databinding.InverseMethod
import com.example.searchrestaurantapp.R

object RestaurantDistanceConverter {


    @InverseMethod("buttonIdToDistanceCode")
    @JvmStatic
    fun distanceCodeToButtonId(context: Context, restaurantDistanceCode :Int): Int {
        Log.d("distanceCodeToButtonId", "distanceCodeToButtonId method starts")

        var selectedButtonId: Int = -1

        val stRestaurantDistanceCodes: Array<String> = context.resources.getStringArray(R.array.restaurant_distance_codes)
        // Array<String>のstRestaurantDistanceCodesをArray<Int>のintRestaurantDistanceCodesに変換
        val intRestaurantDistanceCodes: Array<Int> = stRestaurantDistanceCodes.map { it.toInt() }.toTypedArray()
        val mutRestaurantDistanceCodes: MutableList<Int> = intRestaurantDistanceCodes.toMutableList()

        Log.d("selectedButtonId", "initial selectedButtonId is $selectedButtonId")
        Log.d("restaurantDistanceCode", "restaurantDistanceCode of distanceCodeToButtonId argument is $restaurantDistanceCode")

        restaurantDistanceCode.run {
            selectedButtonId = when (restaurantDistanceCode) {
                mutRestaurantDistanceCodes[0] -> R.id.minimum_distance
                mutRestaurantDistanceCodes[1] -> R.id.middle_distance
                mutRestaurantDistanceCodes[2] -> R.id.max_distance
                else -> R.id.minimum_distance
            }
        }
        Log.d("selectedButtonId", "selected selectedButtonId is $selectedButtonId")
        Log.d("distanceCodeToButtonId", "distanceCodeToButtonId method ends")
        return selectedButtonId
    }

    @JvmStatic
    fun buttonIdToDistanceCode(context: Context, selectedButtonId: Int): Int {
        Log.d("buttonIdToDistanceCode", "buttonIdToDistanceCode method starts")
        val stRestaurantDistanceCodes: Array<String> = context.resources.getStringArray(R.array.restaurant_distance_codes)
        // Array<String>のstRestaurantDistanceCodesをArray<Int>のintRestaurantDistanceCodesに変換
        val intRestaurantDistanceCodes: Array<Int> = stRestaurantDistanceCodes.map { it.toInt() }.toTypedArray()
        val mutRestaurantDistanceCodes: MutableList<Int> = intRestaurantDistanceCodes.toMutableList()

        var restaurantDistanceCode: Int = mutRestaurantDistanceCodes[0]
        Log.d("restaunrantDistanceCode", "initial restaurantDistanceCode is $restaurantDistanceCode")
        Log.d("selectedButtonId", "selectedId buttonIdToDistanceCode argument is $selectedButtonId")
        when (selectedButtonId) {
            R.id.minimum_distance -> {
                restaurantDistanceCode = mutRestaurantDistanceCodes[0]
            }
            R.id.middle_distance -> {
                restaurantDistanceCode = mutRestaurantDistanceCodes[1]
            }
            R.id.max_distance -> {
                restaurantDistanceCode= mutRestaurantDistanceCodes[2]
            }
        }

        Log.d("restaurantDistanceCode", "selected restaurantDistanceCode is $restaurantDistanceCode")
        Log.d("buttonIdToDistanceCode", "buttonIdToDistanceCode method ends")
        return restaurantDistanceCode
    }
}