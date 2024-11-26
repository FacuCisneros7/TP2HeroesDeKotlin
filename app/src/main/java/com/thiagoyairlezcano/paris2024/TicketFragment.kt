package com.thiagoyairlezcano.paris2024

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.navigation.fragment.findNavController

class TicketFragment : Fragment() {

    lateinit var ticket_pro: LinearLayout
    lateinit var ticket_ultra: LinearLayout
    lateinit var ticket_ultimate: LinearLayout


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {


        val root=inflater.inflate(R.layout.fragment_ticket, container, false)
        val idUsuario = arguments?.getLong("idUsuario") ?: 0L

        iniciarTickets(root,idUsuario)

        return root
    }

    private fun iniciarTickets(root: View, idUsuario: Long) {
        ticket_pro= root.findViewById(R.id.ticket_pro)
        ticket_ultra= root.findViewById(R.id.ticket_ultra)
        ticket_ultimate= root.findViewById(R.id.ticket_ultimate)


        ticket_pro.setOnClickListener { findNavController().navigate(TicketFragmentDirections.actionTicketFragmentToEventosFragment(idUsuario = idUsuario, ticket = 1)) }
        ticket_ultra.setOnClickListener { findNavController().navigate(TicketFragmentDirections.actionTicketFragmentToEventosFragment(idUsuario = idUsuario, ticket = 2)) }
        ticket_ultimate.setOnClickListener { findNavController().navigate(TicketFragmentDirections.actionTicketFragmentToEventosFragment(idUsuario = idUsuario, ticket = 3)) }
    }

}