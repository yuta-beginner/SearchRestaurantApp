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

    // enumはdataパッケージにおくべき
    // viewmodelはAPIの通信（何をどうしたいですか）
    // modelの方でenumを管理
    // resourcesにAPI用の配列を同じ長さで作る。
    // API通信では対応するものをresourcesからとってくる。
    // indexはmodelのロジックでとってくる。
    // enumは内部のもっと細かい部分に関わる定数（一部的なデータ調整のパラメータ）
    // xmlに定義しておくことで、API修正の時にxmlだけ修正するだけでOKとなる=>補修性高い
    // RESTAPIはクライアントからのリクエスト
    // Rxはサーバーからの通信に受ける。
    // viewmodelはコミュニケーション部分に特化させる。
    // kotlinの言語思想（１ファイルに複数クラス）とアーキテクチャ（オブジェクト指向）は分けて考えるべき。
    // javaのinnerクラスは危ないという考え方もある。少なくとも気をつけなければならない。
    // enum使っちゃえば楽だが、末端の定数（よっぽど変わらない定数）はxmlに定義すべき=>保守性の観点

    private val initialRestaurantDistanceCode: Int = 1
    private val initialRestaurantGenreCode: String= "G001"

    var _distance = MutableLiveData(initialRestaurantDistanceCode)
    val distance = _distance

    // modelで変換したものをMutableLiveData<String(model.convertにする。)
    var _restaurantGenre = MutableLiveData<String>(initialRestaurantGenreCode)
    val restaurantGenre = _restaurantGenre
}