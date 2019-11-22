package com.example.controllocales

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        val ITEM_SELECTED = "ItemSelected"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val detailActivityIntent = Intent(this, DetailActivity::class.java)

        val centroComercialSpinnerAdapter = ArrayAdapter.createFromResource(this,
            R.array.tipos_centros_comerciales_array,
            android.R.layout.simple_spinner_item)

        val almacenesSpinnerAdapter = ArrayAdapter.createFromResource(this,
            R.array.tipos_almacenes_array,
            android.R.layout.simple_spinner_item)

        centros_comerciales_spinner.adapter = centroComercialSpinnerAdapter
        centros_comerciales_spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                Log.d("HomeActivity", "Nothing Selected")
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                if (position != 0){
                    detailActivityIntent.putExtra(ITEM_SELECTED,
                        centros_comerciales_spinner.selectedItem.toString())
                    startActivity(detailActivityIntent)
                }
            }

        }

        almacenes_spinner.adapter = almacenesSpinnerAdapter
        almacenes_spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                if (position != 0){
                    detailActivityIntent.putExtra(ITEM_SELECTED,
                        almacenes_spinner.selectedItem.toString())
                    startActivity(detailActivityIntent)
                }

            }

        }
    }
}
