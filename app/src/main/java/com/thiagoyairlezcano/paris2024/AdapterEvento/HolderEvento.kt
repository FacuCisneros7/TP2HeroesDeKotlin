package com.thiagoyairlezcano.juegosolimpicosparis.AdapterEvento

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso
import com.thiagoyairlezcano.paris2024.R
import data.Event

class HolderEvento(view: View) : RecyclerView.ViewHolder(view) {

    val logo= view.findViewById<ShapeableImageView>(R.id.siv_evento)
    val lugar= view.findViewById<TextView>(R.id.tv_lugar)
    val horario= view.findViewById<TextView>(R.id.tv_hora)
    val fecha= view.findViewById<TextView>(R.id.tv_fecha)
    val costo= view.findViewById<TextView>(R.id.tv_costo)

    val item= view



    fun render(event: Event, onEventSelected: (Long) -> Unit){
        lugar.text=event.place.toString()
        horario.text=event.hour.toString()
        fecha.text=event.date
        costo.text=event.price.toString()

        Picasso.get().load(event.sport.logo).into(logo)
        item.setOnClickListener { onEventSelected(event.id) }
    }




}