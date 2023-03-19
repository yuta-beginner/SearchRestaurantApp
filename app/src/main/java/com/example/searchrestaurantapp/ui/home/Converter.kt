package com.example.searchrestaurantapp.ui.home



import androidx.databinding.InverseMethod
import com.example.searchrestaurantapp.R
import com.google.android.material.textfield.TextInputLayout

object Converter {
    @InverseMethod("stringToCategory")
    @JvmStatic
    fun categoryToString(view: TextInputLayout, categoryId: String): String {
        var genreTextString: String = HomeViewModel.RestaurantGenreItem.JAPANESE_PUB.restaurantGenre
        categoryId.run {
            genreTextString = when (categoryId) {
                HomeViewModel.RestaurantGenreItem.JAPANESE_PUB.restaurantGenre -> view.resources.getString(R.string.japanese_pub)
                HomeViewModel.RestaurantGenreItem.DINING_BAR_AND_BAL.restaurantGenre -> view.resources.getString(R.string.dining_bar_and_bal)
                HomeViewModel.RestaurantGenreItem.CREATIVE_CUISINE.restaurantGenre -> view.resources.getString(R.string.creative_cuisine)
                HomeViewModel.RestaurantGenreItem.JAPANESE_CUISINE.restaurantGenre -> view.resources.getString(R.string.japanese_cuisine)
                HomeViewModel.RestaurantGenreItem.WESTERN_CUISINE.restaurantGenre -> view.resources.getString(R.string.western_cuisine)
                HomeViewModel.RestaurantGenreItem.ITALIAN_AND_FRENCH_CUISINE.restaurantGenre -> view.resources.getString(R.string.italian_and_french_cuisine)
                HomeViewModel.RestaurantGenreItem.CHINESE_CUISINE.restaurantGenre -> view.resources.getString(R.string.chinese_cuisine)
                HomeViewModel.RestaurantGenreItem.KOREAN_BARBECUE_AND_INNARDS.restaurantGenre -> view.resources.getString(R.string.korean_barbecue_and_innards)
                HomeViewModel.RestaurantGenreItem.ASIA_AND_ETHNIC_CUISINE.restaurantGenre -> view.resources.getString(R.string.asia_and_ethnic_cuisine)
                HomeViewModel.RestaurantGenreItem.WORLD_CUISINE.restaurantGenre -> view.resources.getString(R.string.world_cuisine)
                HomeViewModel.RestaurantGenreItem.KARAOKE_AND_PARTY.restaurantGenre -> view.resources.getString(R.string.karaoke_and_party)
                HomeViewModel.RestaurantGenreItem.BAR_AND_COCKTAIL.restaurantGenre -> view.resources.getString(R.string.bar_and_cocktail)
                HomeViewModel.RestaurantGenreItem.RAMEN_NOODLES.restaurantGenre -> view.resources.getString(R.string.ramen_noodles)
                HomeViewModel.RestaurantGenreItem.CAFE_AND_SWEETS.restaurantGenre -> view.resources.getString(R.string.cafe_and_sweets)
                HomeViewModel.RestaurantGenreItem.OTHER_CUISINE.restaurantGenre -> view.resources.getString(R.string.other_cuisine)
                HomeViewModel.RestaurantGenreItem.OKONOMIYAKI_AND_MONJAYAKI.restaurantGenre -> view.resources.getString(R.string.okonomiyaki_and_monjayaki)
                HomeViewModel.RestaurantGenreItem.KOREAN_CUISINE.restaurantGenre -> view.resources.getString(R.string.korean_cuisine)
                else -> view.resources.getString(R.string.japanese_pub)
            }
        }
        return genreTextString
    }

    @JvmStatic
    fun stringToCategory(view: TextInputLayout, textString: String): String {
        var categoryId: String = HomeViewModel.RestaurantGenreItem.JAPANESE_PUB.restaurantGenre
        when (textString) {
            view.resources.getString(R.string.japanese_pub)-> {
                categoryId = HomeViewModel.RestaurantGenreItem.JAPANESE_PUB.restaurantGenre
            }
            view.resources.getString(R.string.dining_bar_and_bal) -> {
                categoryId = HomeViewModel.RestaurantGenreItem.DINING_BAR_AND_BAL.restaurantGenre
            }
            view.resources.getString(R.string.creative_cuisine) -> {
                categoryId = HomeViewModel.RestaurantGenreItem.CREATIVE_CUISINE.restaurantGenre
            }
            view.resources.getString(R.string.japanese_cuisine) -> {
                categoryId = HomeViewModel.RestaurantGenreItem.JAPANESE_CUISINE.restaurantGenre
            }
            view.resources.getString(R.string.western_cuisine) -> {
                categoryId = HomeViewModel.RestaurantGenreItem.WESTERN_CUISINE.restaurantGenre
            }
            view.resources.getString(R.string.italian_and_french_cuisine) -> {
                categoryId = HomeViewModel.RestaurantGenreItem.ITALIAN_AND_FRENCH_CUISINE.restaurantGenre
            }
            view.resources.getString(R.string.chinese_cuisine) -> {
                categoryId = HomeViewModel.RestaurantGenreItem.CHINESE_CUISINE.restaurantGenre
            }
            view.resources.getString(R.string.korean_barbecue_and_innards) -> {
                categoryId = HomeViewModel.RestaurantGenreItem.KOREAN_BARBECUE_AND_INNARDS.restaurantGenre
            }
            view.resources.getString(R.string.asia_and_ethnic_cuisine) -> {
                categoryId = HomeViewModel.RestaurantGenreItem.ASIA_AND_ETHNIC_CUISINE.restaurantGenre
            }
            view.resources.getString(R.string.world_cuisine) -> {
                categoryId = HomeViewModel.RestaurantGenreItem.WORLD_CUISINE.restaurantGenre
            }
            view.resources.getString(R.string.karaoke_and_party) -> {
                categoryId = HomeViewModel.RestaurantGenreItem.KARAOKE_AND_PARTY.restaurantGenre
            }
            view.resources.getString(R.string.bar_and_cocktail) -> {
                categoryId = HomeViewModel.RestaurantGenreItem.BAR_AND_COCKTAIL.restaurantGenre
            }
            view.resources.getString(R.string.ramen_noodles) -> {
                categoryId = HomeViewModel.RestaurantGenreItem.RAMEN_NOODLES.restaurantGenre
            }
            view.resources.getString(R.string.japanese_cuisine) -> {
                categoryId = HomeViewModel.RestaurantGenreItem.JAPANESE_CUISINE.restaurantGenre
            }
            view.resources.getString(R.string.cafe_and_sweets) -> {
                categoryId = HomeViewModel.RestaurantGenreItem.CAFE_AND_SWEETS.restaurantGenre
            }
            view.resources.getString(R.string.other_cuisine) -> {
                categoryId = HomeViewModel.RestaurantGenreItem.OTHER_CUISINE.restaurantGenre
            }
            view.resources.getString(R.string.okonomiyaki_and_monjayaki) -> {
                categoryId = HomeViewModel.RestaurantGenreItem.OKONOMIYAKI_AND_MONJAYAKI.restaurantGenre
            }
            view.resources.getString(R.string.korean_cuisine) -> {
                categoryId = HomeViewModel.RestaurantGenreItem.KOREAN_CUISINE.restaurantGenre
            }
        }
        return categoryId
    }
}