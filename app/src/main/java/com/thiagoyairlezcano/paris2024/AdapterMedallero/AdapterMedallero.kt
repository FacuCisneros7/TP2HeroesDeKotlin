

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.thiagoyairlezcano.juegosolimpicosparis.AdapterMedallero.HolderMedallero
import com.thiagoyairlezcano.paris2024.R
import data.Country

class AdapterMedallero(val listaMedallero:List<Country>):RecyclerView.Adapter<HolderMedallero>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderMedallero {
       val layoutInflater= LayoutInflater.from(parent.context)
       return HolderMedallero(layoutInflater.inflate(R.layout.item_medallero, parent, false))
    }

    override fun getItemCount(): Int {
        return listaMedallero.size
    }

    override fun onBindViewHolder(holder: HolderMedallero, position: Int) {
        val item= listaMedallero[position]
        return holder.render(item)
    }

}