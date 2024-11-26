package com.thiagoyairlezcano.paris2024

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.jakewharton.threetenabp.AndroidThreeTen
import repositories.UserRepository

class LoginActivity : AppCompatActivity() {

    val usuarios= UserRepository
    lateinit var btInicio:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        AndroidThreeTen.init(this)

        btInicio= findViewById(R.id.bt_inicio)
        btInicio.setOnClickListener { inicioSesion() }
    }

    fun inicioSesion(){
        val nickName= findViewById<EditText>(R.id.et_Asiento).text.toString()
        val password= findViewById<EditText>(R.id.et_password).text.toString()
        val usuarioExistente=usuarios.login(nickName,password)

        if (usuarioExistente!=null){
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("idUsuario", usuarioExistente?.id)
            startActivity(intent)
            finish()
        }else{
            Toast.makeText(this, "Usuario No Encontrado", Toast.LENGTH_SHORT).show()
        }

    }
}