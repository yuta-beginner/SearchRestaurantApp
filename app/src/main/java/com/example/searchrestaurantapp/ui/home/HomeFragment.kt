package com.example.searchrestaurantapp.ui.home

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.text.InputType
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.annotation.LayoutRes
import androidx.appcompat.widget.AppCompatAutoCompleteTextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.searchrestaurantapp.R
import com.example.searchrestaurantapp.databinding.FragmentHomeBinding
import com.google.android.material.textfield.TextInputLayout

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.i("HomeFragment", "onCreateView start")
        val homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        //val homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        binding.homeViewModel = homeViewModel
        binding.lifecycleOwner = viewLifecycleOwner
        val root: View = binding.root

        val radioGroup : RadioGroup = binding.radioButtonGroupDistance
        homeViewModel.distance?.observe(viewLifecycleOwner){
            radioGroup.check(homeViewModel.distanceToButtonId(it))
            Log.d("distance", "${homeViewModel.distance!!.value}")
        }

        /*radioGroup.setOnCheckedChangeListener { group, checkedId ->
            homeViewModel.setRadioType(checkedId)
            Log.d("radioTypeChanged", "${homeViewModel.radioType!!.value}")
        }*/


        var autoCompleteTextView = binding.outlinedExposedDropdown
        val menuItems = resources.getStringArray(R.array.option_genre)
        val menuItemsList:MutableList<String> = menuItems.toMutableList()


        // お店のジャンルAdapterを作成。
        val genreAdapter : ArrayAdapter<String> = GenreDropDownAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, menuItemsList)
        // アダプターをセット
        autoCompleteTextView.setAdapter(genreAdapter)
        // 初期に表示される飲食店のジャンルを表示
        var defaultRestaurantGenre:String = menuItemsList[0]
        autoCompleteTextView.setText(defaultRestaurantGenre)

        return root
    }

    override fun onDestroyView() {
        val autoCompleteTextView = binding.outlinedExposedDropdown
        autoCompleteTextView.setAdapter(null)
        Log.i("HomeFragment", "onDestroyView")
        super.onDestroyView()
        _binding = null
    }
}

class GenreDropDownAdapter(context: Context, @LayoutRes private val layoutResource: Int, private val allRestaurantGenre: MutableList<String>):
    ArrayAdapter<String>(context,layoutResource,allRestaurantGenre),
    Filterable{
    private var mutableAllRestaurantGenre:MutableList<String> = allRestaurantGenre

    override fun getFilter(): Filter {
        return object: Filter(){
            override fun publishResults(charSequence: CharSequence?, filterResults: FilterResults? ){
                if (filterResults != null) {
                    mutableAllRestaurantGenre = filterResults.values  as MutableList<String>
                    if(filterResults.count > 0)
                        notifyDataSetChanged()
                    else
                        notifyDataSetInvalidated()
                }
            }

            override fun performFiltering(charSequence: CharSequence?): FilterResults {
                val filterResults : FilterResults = FilterResults()
                val newItems : MutableList<String> = allRestaurantGenre
                filterResults.values = newItems
                filterResults.count = newItems.size
                return filterResults
            }
        }
    }
}