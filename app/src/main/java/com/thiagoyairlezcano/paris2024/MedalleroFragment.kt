package com.thiagoyairlezcano.paris2024

import AdapterMedallero
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import repositories.MedalTableRepository

class MedalleroFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root= inflater.inflate(R.layout.fragment_medallero, container, false)
        iniciarMedallero(root)

        return root
    }

    fun iniciarMedallero(root: View) {
        val contenedor= root.findViewById<RecyclerView>(R.id.rvMedallero)

        val manager= LinearLayoutManager(root.context)
        val decoration= DividerItemDecoration(root.context, manager.orientation)
        contenedor.adapter=AdapterMedallero(MedalTableRepository.get())
        contenedor.layoutManager=manager

        contenedor.addItemDecoration(decoration)
    }

}