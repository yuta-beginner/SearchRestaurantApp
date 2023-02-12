package com.example.searchrestaurantapp.ui.dashboard

import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.preference.PreferenceManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.searchrestaurantapp.databinding.FragmentDashboardBinding
import org.osmdroid.config.Configuration
import org.osmdroid.tileprovider.tilesource.XYTileSource
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.Marker
import org.osmdroid.views.overlay.ScaleBarOverlay

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        /*val textView: TextView = binding.textDashboard
        dashboardViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }*/

        var map: MapView = binding.map
        Configuration.getInstance().load(requireContext(), PreferenceManager.getDefaultSharedPreferences(requireContext()))


        /*val tileSource = XYTileSource("GSI", 5, 30, 256,
            ".png", arrayOf("https://cyberjapandata.gsi.go.jp/xyz/std/"), "地理院タイル")
        map.setTileSource(tileSource)*/
        map.setMultiTouchControls(true)

        val mapController = map.controller
        mapController.setZoom(15.0) // ズームレベル 15
        mapController.setCenter(GeoPoint(35.658581,  139.745433))

        // markerを地図に表示
        var sampleMarker = Marker(map)
        var gp = GeoPoint(35.658581,  139.745433)
        sampleMarker.position = gp
        sampleMarker.title = "サンプル"
        sampleMarker.snippet = "https://www.youtube.com/"
        sampleMarker.setAnchor(Marker.ANCHOR_BOTTOM, Marker.ANCHOR_CENTER)

        // scale barを地図に表示
        val scaleBar = ScaleBarOverlay(map)
        scaleBar.setAlignRight(true)
        scaleBar.setScaleBarOffset(50, 50)
        scaleBar.setTextSize(10 * this.resources.displayMetrics.density)
        map.overlays.add(scaleBar)


        showMarkerDialog(sampleMarker)

        map.overlays.add(sampleMarker)
        map.invalidate()
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun showMarkerDialog(marker : Marker) {
        marker!!.setOnMarkerClickListener { marker, mapView ->
            val dialog = SimpleDialogFragment()
            dialog.show(childFragmentManager, "simple")
            true
        }
    }

    inner class SimpleDialogFragment: DialogFragment(){
        override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

            val builder = AlertDialog.Builder(activity)

            builder.setTitle("Here Title")
                .setMessage("Here Message")
                .setPositiveButton("done") { dialog, id ->
                    println("dialog:$dialog which:$id")
                }
                .setNegativeButton("cancel") { dialog, id ->
                    println("dialog:$dialog which:$id")
                }

            return builder.create()
        }
    }
}