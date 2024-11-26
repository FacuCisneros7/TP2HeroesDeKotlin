package com.thiagoyairlezcano.paris2024

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.findNavController
import com.jakewharton.threetenabp.AndroidThreeTen

class MainActivity : AppCompatActivity() {


    lateinit var ib_Medallero: ImageButton
    lateinit var ib_Usuario: ImageButton
    lateinit var ib_Ticket: ImageButton

    lateinit var btn_salir: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }

        botonesNav()
        ib_Usuario.callOnClick()


        btn_salir=findViewById(R.id.btn_salida)
        btn_salir.setOnClickListener {
            val intent= Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

    }

    override fun onBackPressed() {

        val navegacion= findNavController(R.id.nav_host_fragment_activity_main)
        if (navegacion.currentDestination?.id != R.id.userFragment) {
            navegacion.popBackStack(R.id.userFragment, false)
        } else {
            super.onBackPressed()
            super.onBackPressed()
        }
    }

    fun botonesNav(){
        ib_Medallero=findViewById(R.id.ib_medallero)
        ib_Usuario=findViewById(R.id.ib_usuario)
        ib_Ticket=findViewById(R.id.ib_ticket)
    }


    fun navegacion(view: View){
        var color = ContextCompat.getColor(view.context, R.color.white)
        ib_Medallero.setBackgroundColor(color)
        ib_Usuario.setBackgroundColor(color)
        ib_Ticket.setBackgroundColor(color)

        color = ContextCompat.getColor(view.context, R.color.gray)
        view.setBackgroundColor(color)

        var idUsuario= intent.getLongExtra("idUsuario", 0L)

        val bundle = Bundle().apply {
            putLong("idUsuario", idUsuario)
        }

        val managerNav= findNavController(R.id.nav_host_fragment_activity_main)

        when(view.id){
            R.id.ib_medallero->{managerNav.navigate(R.id.medalleroFragment)}
            R.id.ib_usuario->{managerNav.navigate(R.id.userFragment, bundle)}
            R.id.ib_ticket->{managerNav.navigate(R.id.ticketFragment, bundle)}
        }

    }
}