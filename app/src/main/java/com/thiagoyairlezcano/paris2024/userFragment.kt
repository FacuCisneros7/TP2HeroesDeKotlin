package com.thiagoyairlezcano.paris2024

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.thiagoyairlezcano.paris2024.AdapterHistorial.AdapterHistorial
import data.User
import repositories.PurchaseRepository
import repositories.UserRepository

class userFragment : Fragment() {

    lateinit var tv_user_nickName: TextView
    lateinit var siv_user_img: ShapeableImageView
    lateinit var tv_user_name: TextView
    lateinit var tv_user_money: TextView
    lateinit var tv_user_create: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root=inflater.inflate(R.layout.fragment_user, container, false)
        val idUsuario = arguments?.getLong("idUsuario") ?: 0L
        val usuarioObtenido= UserRepository.buscarusuario(idUsuario)

        buscarUsuario(root, usuarioObtenido)
        iniciarHistorial(root, usuarioObtenido)
        return root

    }

    private fun buscarUsuario(root: View, usuario: User?) {

        tv_user_nickName= root.findViewById(R.id.tv_user_nickName)
        siv_user_img= root.findViewById(R.id.siv_user_img)
        tv_user_name= root.findViewById(R.id.tv_user_name)
        tv_user_money= root.findViewById(R.id.tv_user_money)
        tv_user_create= root.findViewById(R.id.tv_user_create)



        if (usuario!=null){
            tv_user_nickName.text=usuario.nickName
            tv_user_name.text="${usuario.name} ${usuario.surname}"
            tv_user_money.text="Saldo: ${usuario.money}"
            tv_user_create.text=usuario.createdDate
        }

    }

    fun iniciarHistorial(root: View, usuarioObtenido: User?) {
        val contenedor= root.findViewById<RecyclerView>(R.id.rv_historial)

        val manager= GridLayoutManager(root.context, 1, GridLayoutManager.HORIZONTAL, false)

        if (usuarioObtenido != null) {
            contenedor.adapter=AdapterHistorial(PurchaseRepository.getByUserId(usuarioObtenido.id))
        }
        contenedor.layoutManager=manager
    }


}