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
        MINIMUM_DISTANCE(1),
        MIDDLE_DISTANCE(2),
        MAX_DISTANCE(3)
    }

    enum class RestaurantGenreItem(val restaurantGenre: String) {
        JAPANESE_PUB("G001"),
        DINING_BAR_AND_BAL("G002"),
        CREATIVE_CUISINE("G003"),
        JAPANESE_CUISINE("G004"),
        WESTERN_CUISINE("G005"),
        ITALIAN_AND_FRENCH_CUISINE("G006"),
        CHINESE_CUISINE("G007"),
        KOREAN_BARBECUE_AND_INNARDS("G008"),
        ASIA_AND_ETHNIC_CUISINE("G009"),
        WORLD_CUISINE("G010"),
        KARAOKE_AND_PARTY("G011"),
        BAR_AND_COCKTAIL("G012"),
        RAMEN_NOODLES("G013"),
        CAFE_AND_SWEETS("G014"),
        OTHER_CUISINE("G015"),
        OKONOMIYAKI_AND_MONJAYAKI("G016"),
        KOREAN_CUISINE("G017")
    }

    var _distance = MutableLiveData(RadioType.MINIMUM_DISTANCE.restaurantDistance)
    val distance = _distance

    var _restaurantGenre = MutableLiveData<String>(RestaurantGenreItem.JAPANESE_PUB.restaurantGenre)
    val restaurantGenre = _restaurantGenre

}