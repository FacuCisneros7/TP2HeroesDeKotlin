package com.thiagoyairlezcano.juegosolimpicosparis.AdapterMedallero

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso
import com.thiagoyairlezcano.paris2024.R
import data.Country

class HolderMedallero(view: View) : RecyclerView.ViewHolder(view) {

    val nombre= view.findViewById<TextView>(R.id.tv_nombre)
    val puesto= view.findViewById<TextView>(R.id.tv_puesto)
    val oro= view.findViewById<TextView>(R.id.tv_oro)
    val plata= view.findViewById<TextView>(R.id.tv_plata)
    val bronce= view.findViewById<TextView>(R.id.tv_bronce)
    val img=view.findViewById<ShapeableImageView>(R.id.iv_bandera)

    fun render(country: Country){
        nombre.text=country.name.toString()
        puesto.text=country.position.toString()
        oro.text=country.goldMedals.toString()
        plata.text=country.silverMedals.toString()
        bronce.text=country.bronzeMedals.toString()
        Picasso.get().load(country.flag).error(R.drawable.error_img).into(img)
    }


}