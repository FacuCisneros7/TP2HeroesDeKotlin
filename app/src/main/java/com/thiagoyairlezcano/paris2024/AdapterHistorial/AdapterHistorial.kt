package com.thiagoyairlezcano.paris2024.AdapterHistorial

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.thiagoyairlezcano.paris2024.R
import data.Purchase

class AdapterHistorial(val listaHistorial:List<Purchase>): RecyclerView.Adapter<HolderHistorial>()  {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderHistorial {
        val layoutInflater= LayoutInflater.from(parent.context)
        return HolderHistorial(layoutInflater.inflate(R.layout.item_historial, parent, false))
    }

    override fun getItemCount(): Int {
       return listaHistorial.size
    }

    override fun onBindViewHolder(holder: HolderHistorial, position: Int) {
        val item= listaHistorial[position]
        return holder.render(item)
    }
}