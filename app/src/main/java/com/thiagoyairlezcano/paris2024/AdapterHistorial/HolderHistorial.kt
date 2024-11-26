package com.thiagoyairlezcano.paris2024.AdapterHistorial

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.thiagoyairlezcano.paris2024.R
import data.Purchase
import repositories.EventRepository

class HolderHistorial(view: View) : RecyclerView.ViewHolder(view) {

    val siv_h_evento= view.findViewById<ShapeableImageView>(R.id.siv_h_evento)
    val tv_h_lugar= view.findViewById<TextView>(R.id.tv_h_lugar)
    val tv_h_hora= view.findViewById<TextView>(R.id.tv_h_hora)
    val tv_h_fecha= view.findViewById<TextView>(R.id.tv_h_fecha)
    val tv_h_asiento= view.findViewById<TextView>(R.id.tv_h_asiento)

    fun render(purchase: Purchase) {

        val evento=EventRepository.getById(purchase.eventId)

        if (evento != null) {
            tv_h_lugar.text="${evento.place}"
            tv_h_hora.text="${evento.hour}"
            tv_h_fecha.text="${evento.date}"
            tv_h_asiento.text="${purchase.seat}"

            when(evento.sport.id){
                1L->{siv_h_evento.setImageResource(R.drawable.fondo_futbol)}
                2L->{siv_h_evento.setImageResource(R.drawable.fondo_basquet)}
                3L->{siv_h_evento.setImageResource(R.drawable.fondo_atletismo)}
                4L->{siv_h_evento.setImageResource(R.drawable.fondo_natacion)}
                5L->{siv_h_evento.setImageResource(R.drawable.fondo_ritmica)}
                6L->{siv_h_evento.setImageResource(R.drawable.fondo_ciclismo)}
                7L->{siv_h_evento.setImageResource(R.drawable.fondo_remo)}
                8L->{siv_h_evento.setImageResource(R.drawable.fondo_esgrima)}
                9L->{siv_h_evento.setImageResource(R.drawable.fondo_judp)}
                10L->{siv_h_evento.setImageResource(R.drawable.fondo_tenis)}
            }

        }

    }
}