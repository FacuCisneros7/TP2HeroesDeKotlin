package com.thiagoyairlezcano.paris2024

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.material.imageview.ShapeableImageView
import data.Elite
import data.Event
import data.Purchase
import data.TicketPro
import data.UltimateEvent
import data.User
import repositories.EventRepository
import repositories.PurchaseRepository
import repositories.UserRepository
import org.threeten.bp.LocalDate
import org.threeten.bp.DayOfWeek
import org.threeten.bp.format.DateTimeFormatter


class CompraFragment : Fragment() {

    val args: CompraFragmentArgs by navArgs()

    lateinit var ticketFondo:ShapeableImageView

    lateinit var botonParaComprar:Button

    lateinit var siv_deporte_img: ShapeableImageView
    lateinit var tv_detalle_deporte:TextView
    lateinit var tv_detalle_lugar:TextView
    lateinit var tv_detalle_asiento:TextView
    lateinit var tv_detalle_fecha:TextView
    lateinit var tv_detalle_horario:TextView
    lateinit var tv_detalle_valorTotal:TextView
    lateinit var tv_detalle_saldo: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root= inflater.inflate(R.layout.fragment_compra, container, false)

        val usuario = UserRepository.buscarusuario(args.idUsuario)
        val evento = EventRepository.getById(args.idEvento)
        var precioFinal = calcularPrecioFinal(args.ticket, evento?.price ?: 0.0)


        if (evento != null) {
            rellenar(root, evento,usuario?.money.toString().toDouble(),precioFinal)
        }


        val day = LocalDate.now()
        val fecha: String = day.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))




        botonParaComprar= root.findViewById(R.id.btn_compra)
        botonParaComprar.setOnClickListener {
            if (evento != null) {
                compra(root,usuario,precioFinal, evento, fecha, args.asiento.toString())
            }
        }



        return root
    }





    fun compra(
        root: View,
        usuario: User?,
        precioFinal: Double,
        evento: Event,
        fecha: String,
        asiento: String
    ) {

        val bundle = Bundle().apply {
            putLong("idUsuario", usuario?.id ?: 0)
        }

        if (usuario?.money.toString().toDouble() > precioFinal) {
            val newPurchase = registrarCompra(usuario!!, evento, precioFinal, fecha, asiento, PurchaseRepository)
            UserRepository.restarPrecioAlSaldo(usuario, precioFinal)
            Toast.makeText(root.context, "La compra se realizó correctamente", Toast.LENGTH_LONG).show()

            findNavController().navigate(R.id.userFragment,bundle)
        } else {
            Toast.makeText(root.context, "No se pudo realizar la compra, saldo insuficiente", Toast.LENGTH_SHORT).show()
        }
    }

    fun registrarCompra(usuario: User, evento: Event, precio: Double, fecha: String, asiento: String, purchaseRepo: PurchaseRepository): Purchase {
        val lastId = purchaseRepo.get().maxOfOrNull { it.id } ?: 0
        val nuevaCompra = Purchase(lastId + 1, usuario.id, evento.id, precio, fecha, asiento)
        purchaseRepo.add(nuevaCompra)
        return nuevaCompra
    }


    fun calcularPrecioFinal(indice: Int, precioBase: Double): Double{
        return when (indice) {
            1 -> {
                TicketPro().calcularComision(precioBase)
            }

            2 -> {
                Elite().calcularComision(precioBase)
            }

            3 -> {
                UltimateEvent().calcularComision(precioBase)
            }
            else -> 0.0
        }

    }


    fun rellenar(root: View, evento: Event, usuarioMoney: Double, precioFinal: Double){

        tv_detalle_deporte= root.findViewById(R.id.tv_detalle_deporte)
        tv_detalle_lugar= root.findViewById(R.id.tv_detalle_lugar)
        tv_detalle_fecha= root.findViewById(R.id.tv_detalle_fecha)
        tv_detalle_horario= root.findViewById(R.id.tv_detalle_horario)
        tv_detalle_valorTotal= root.findViewById(R.id.tv_detalle_valorTotal)
        tv_detalle_asiento= root.findViewById(R.id.tv_detalle_asiento)

        tv_detalle_saldo=root.findViewById(R.id.tv_detalle_saldo)



        tv_detalle_deporte.text="Deporte: ${evento?.sport?.name}"
        tv_detalle_lugar.text="Lugar: ${evento?.place}"
        tv_detalle_asiento.text="Asiento: ${args.asiento}"
        tv_detalle_fecha.text="Fecha: ${evento?.date}"
        tv_detalle_horario.text="Horario: ${evento?.hour}"
        tv_detalle_valorTotal.text="Precio Total: ${precioFinal}"



        tv_detalle_saldo.text="$usuarioMoney"

        ticketFondo=root.findViewById(R.id.siv_fondo)
        siv_deporte_img= root.findViewById(R.id.siv_deporte_img)

            when(evento.sport.id){
                1L->{siv_deporte_img.setBackgroundResource(R.drawable.fondo_futbol)}
                2L->{siv_deporte_img.setBackgroundResource(R.drawable.fondo_basquet)}
                3L->{siv_deporte_img.setBackgroundResource(R.drawable.fondo_atletismo)}
                4L->{siv_deporte_img.setBackgroundResource(R.drawable.fondo_natacion)}
                5L->{siv_deporte_img.setBackgroundResource(R.drawable.fondo_ritmica)}
                6L->{siv_deporte_img.setBackgroundResource(R.drawable.fondo_ciclismo)}
                7L->{siv_deporte_img.setBackgroundResource(R.drawable.fondo_remo)}
                8L->{siv_deporte_img.setBackgroundResource(R.drawable.fondo_esgrima)}
                9L->{siv_deporte_img.setBackgroundResource(R.drawable.fondo_judp)}
                10L->{siv_deporte_img.setBackgroundResource(R.drawable.fondo_tenis)}

        }

        when(args.ticket){
            1 -> ticketFondo.setBackgroundColor(ContextCompat.getColor(root.context, R.color.blue_clean))
            2 -> ticketFondo.setBackgroundColor(ContextCompat.getColor(root.context, R.color.orange_clean))
            3 -> ticketFondo.setBackgroundColor(ContextCompat.getColor(root.context, R.color.green_clean))
        }

    }
}