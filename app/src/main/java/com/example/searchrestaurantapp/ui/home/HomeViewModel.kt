package com.example.searchrestaurantapp.ui.home

import android.provider.MediaStore.Audio.Radio
import android.util.Log
import android.widget.RadioButton
import androidx.databinding.InverseMethod
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.searchrestaurantapp.R

class HomeViewModel : ViewModel() {
    init{
        Log.d("HomeViewModel", "HomeViewModel created.")
    }

    /*private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }

    val text: LiveData<String> = _text*/

    enum class RadioType(val restaurantDistance: Int) {
        MINIMUM_DISTANCE(300),
        MIDDLE_DISTANCE(500),
        MAX_DISTANCE(1000),
    }

    val _distance = MutableLiveData(RadioType.MINIMUM_DISTANCE.restaurantDistance)
    val distance = _distance

    @InverseMethod("buttonIdToDistance")
    fun distanceToButtonId(distance: Int) : Int {
        var selectedButtonId = -1

        distance.run{
            selectedButtonId = when(distance){
                RadioType.MINIMUM_DISTANCE.restaurantDistance -> R.id.minimum_distance
                RadioType.MIDDLE_DISTANCE.restaurantDistance -> R.id.middle_distance
                RadioType.MAX_DISTANCE.restaurantDistance -> R.id.max_distance
                else -> R.id.minimum_distance
            }
        }

        return selectedButtonId
    }

    fun buttonIdToDistance(selectedButtonId: Int) : Int {
        var type: Int = RadioType.MINIMUM_DISTANCE.restaurantDistance
        when(selectedButtonId){
            R.id.minimum_distance -> {
                type = RadioType.MINIMUM_DISTANCE.restaurantDistance
            }
            R.id.middle_distance -> {
                type = RadioType.MIDDLE_DISTANCE.restaurantDistance
            }
            R.id.max_distance -> {
                type = RadioType.MAX_DISTANCE.restaurantDistance
            }
        }
        return type
    }
}