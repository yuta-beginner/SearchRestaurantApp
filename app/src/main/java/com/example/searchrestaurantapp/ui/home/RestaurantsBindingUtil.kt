@file:JvmName("RestaurantsBindingUtil")

package com.example.searchrestaurantapp.ui.home

import androidx.databinding.InverseMethod
import com.example.searchrestaurantapp.R


@InverseMethod("buttonIdToDistance")
fun distanceToButtonId(distance: Int): Int {
    var selectedButtonId = -1
    distance.run {
        selectedButtonId = when (distance) {
            HomeViewModel.RadioType.MINIMUM_DISTANCE.restaurantDistance -> R.id.minimum_distance
            HomeViewModel.RadioType.MIDDLE_DISTANCE.restaurantDistance -> R.id.middle_distance
            HomeViewModel.RadioType.MAX_DISTANCE.restaurantDistance -> R.id.max_distance
            else -> R.id.minimum_distance
        }
    }
    return selectedButtonId
}

fun buttonIdToDistance(selectedButtonId: Int): Int {
    var type: Int = HomeViewModel.RadioType.MINIMUM_DISTANCE.restaurantDistance
    when (selectedButtonId) {
        R.id.minimum_distance -> {
            type = HomeViewModel.RadioType.MINIMUM_DISTANCE.restaurantDistance
        }
        R.id.middle_distance -> {
            type = HomeViewModel.RadioType.MIDDLE_DISTANCE.restaurantDistance
        }
        R.id.max_distance -> {
            type = HomeViewModel.RadioType.MAX_DISTANCE.restaurantDistance
        }
    }
    return type
}