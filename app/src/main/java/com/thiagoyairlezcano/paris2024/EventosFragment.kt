package com.thiagoyairlezcano.paris2024

import AdapterEvento
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import repositories.EventRepository



class EventosFragment : Fragment() {

    val args: EventosFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root= inflater.inflate(R.layout.fragment_eventos, container, false)
        iniciarEventos(root)




        return root
    }

    fun eventoSeleccionado(idEvento: Long){
        findNavController().navigate(EventosFragmentDirections.actionEventosFragmentToAsientoFragment(idUsuario = args.idUsuario, ticket = args.ticket ,idEvento = idEvento))
    }

     fun iniciarEventos(root: View) {
        val contenedor= root.findViewById<RecyclerView>(R.id.rvEvento)

        val manager= GridLayoutManager(root.context, 2)
        val decoration= DividerItemDecoration(root.context, manager.orientation)
        contenedor.adapter= AdapterEvento(EventRepository.get()){idEvento-> eventoSeleccionado(idEvento)}
         contenedor.layoutManager=manager

        contenedor.addItemDecoration(decoration)
    }


}