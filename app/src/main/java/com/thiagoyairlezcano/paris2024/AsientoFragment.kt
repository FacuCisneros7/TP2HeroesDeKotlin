package com.thiagoyairlezcano.paris2024

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import repositories.PurchaseRepository


class AsientoFragment : Fragment() {

    val args: AsientoFragmentArgs by navArgs()

    lateinit var boton_seleccion:Button
    lateinit var et_Asiento: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root= inflater.inflate(R.layout.fragment_asiento, container, false)

        boton_seleccion=root.findViewById(R.id.bt_seleccionar)
        et_Asiento=root.findViewById(R.id.et_Asiento)



        boton_seleccion.setOnClickListener {

            et_Asiento=root.findViewById(R.id.et_Asiento)
            val asiento = et_Asiento.text.toString().toIntOrNull()
            val ocupado = PurchaseRepository.estaOcupado(args.idEvento, asiento.toString())

            if (asiento != null && ocupado==false) {
                findNavController().navigate(AsientoFragmentDirections.actionAsientoFragmentToCompraFragment(idUsuario = args.idUsuario, ticket = args.ticket ,idEvento = args.idEvento, asiento = asiento))
            } else {
                Toast.makeText(root.context, "Asiento no valido", Toast.LENGTH_SHORT).show()
            }
        }

        return root
    }


}