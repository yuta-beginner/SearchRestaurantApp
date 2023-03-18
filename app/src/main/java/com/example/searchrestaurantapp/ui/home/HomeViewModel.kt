package com.example.searchrestaurantapp.ui.home

import android.app.Activity
import android.app.Application
import android.content.Context
import android.content.res.Resources
import android.provider.MediaStore.Audio.Radio
import android.provider.Settings.Global.getString
import android.util.Log
import android.widget.RadioButton
import androidx.annotation.StringRes
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.databinding.InverseMethod
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.searchrestaurantapp.R
import kotlin.math.absoluteValue

class HomeViewModel: ViewModel() {
    init{
        Log.d("HomeViewModel", "HomeViewModel created.")
    }

    enum class RadioType(val restaurantDistance: Int) {
        MINIMUM_DISTANCE(300),
        MIDDLE_DISTANCE(500),
        MAX_DISTANCE(1000),
    }

    var _distance = MutableLiveData(RadioType.MINIMUM_DISTANCE.restaurantDistance)
    val distance = _distance

    var _restaurantGenre = MutableLiveData<String>("居酒屋")
    val restaurantGenre = _restaurantGenre

}