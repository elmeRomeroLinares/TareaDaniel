package com.example.controllocales

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val itemSelection = intent.getStringExtra(MainActivity.ITEM_SELECTED)

        when (itemSelection) {
            "Centros Comerciales Grandes" -> centrosComercialesGrandes(detail_spinner)
            "Centros Comerciales Pequeños" -> centrosComercialesPeques(detail_spinner)
            "Múltiples Sucursales" -> multiplesSucursales(detail_spinner)
        }
    }

    private fun centrosComercialesGrandes(spinner: Spinner) {
        val items = arrayOf("Centros Comerciales Grandes:","Multiplaza", "Galerías", "La Gran Vía",
            "Plaza Merliot", "Plaza Centro", "Plaza Futura", "Plaza Mundo")

        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, items)
        spinner.adapter = adapter
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                if (position != 0) {
                    inflateMall(spinner.selectedItem.toString())
                }
            }

        }
    }



    private fun centrosComercialesPeques(spinner: Spinner) {
        val items = arrayOf("Centros Comerciales Pequeños:","La Skina", "Plaza Madero",
            "Olivos Plaza", "Plaza Malta", "Las Palmas", "La Joya", "El Paseo")

        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, items)
        spinner.adapter = adapter
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                if (position != 0) {
                    inflateMall(spinner.selectedItem.toString())
                }
            }

        }
    }

    private fun multiplesSucursales(spinner: Spinner) {
        val items = arrayOf("Múltiples Sucursales:", "SportLine", "Jaguar Sportic",
            "Galaxia Deportes", "Prado", "La Curacao", "Prisma Moda", "Tropigas", "Montecarlo")

        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, items)
        spinner.adapter = adapter
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                if (position != 0) {
                    inflateMall(spinner.selectedItem.toString())
                }
            }

        }

    }

    private fun inflateMall(mallSelected: String) {
        when (mallSelected) {
            "Multiplaza" -> setDetailUI(R.drawable.multiplaza, resources.getStringArray(R.array.multiplazaArray))
            "La Skina" -> setDetailUI(R.drawable.la_skina, resources.getStringArray(R.array.la_skinaArray))
        }
    }

    private fun setDetailUI(imgResource: Int, infoArray: Array<String>) {
        detail_imageView.setImageResource(imgResource)
        detail_imageView.visibility = View.VISIBLE

        nombre_textView.text = infoArray[0]
        nombre_textView.visibility = View.VISIBLE

        ubicacion_textView.text = infoArray[1]
        ubicacion_textView.visibility = View.VISIBLE

        direccion_textView.text = infoArray[2]
        direccion_textView.visibility = View.VISIBLE

        tiendasServicios_textView.text = infoArray[3]
        tiendasServicios_textView.visibility = View.VISIBLE

        centroComercialTipo_textView.text = infoArray[4]
        centroComercialTipo_textView.visibility = View.VISIBLE
    }

}