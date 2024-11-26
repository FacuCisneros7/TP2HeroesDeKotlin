

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.thiagoyairlezcano.juegosolimpicosparis.AdapterEvento.HolderEvento
import com.thiagoyairlezcano.paris2024.R
import data.Event

class AdapterEvento(val listaEvento: List<Event>,private val onEventSelected: (Long) -> Unit):RecyclerView.Adapter<HolderEvento>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderEvento {
       val layoutInflater= LayoutInflater.from(parent.context)
       return HolderEvento(layoutInflater.inflate(R.layout.item_evento, parent, false))
    }

    override fun getItemCount(): Int {
        return listaEvento.size
    }

    override fun onBindViewHolder(holder: HolderEvento, position: Int) {
        val item= listaEvento[position]
        return holder.render(item, onEventSelected)
    }

}