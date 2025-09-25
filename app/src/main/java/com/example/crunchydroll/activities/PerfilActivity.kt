package com.example.crunchydroll.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.content.SharedPreferences
import android.widget.TextView
import com.example.crunchydroll.R

class PerfilActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences

    // Declaramos las vistas como variables globales para poder usarlas en onResume
    private lateinit var tvNombre: TextView
    private lateinit var tvEmail: TextView
    private lateinit var tvTelefono: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil)

        // Inicializamos SharedPreferences
        sharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE)

        // Referenciamos las vistas una sola vez
        tvNombre = findViewById(R.id.nameUser)
        tvEmail = findViewById(R.id.email)
        tvTelefono = findViewById(R.id.telephone)

        // Botón para volver a MainActivity
        val textVolver = findViewById<TextView>(R.id.returnLogin)
        textVolver.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // opcional: cierra esta activity si no quieres volver aquí con el back button
        }

        // Botón para ir a editar perfil
        val btnEditar = findViewById<TextView>(R.id.editButon)
        btnEditar.setOnClickListener {
            val intent = Intent(this, EditProfileActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        cargarDatos()
    }

    private fun cargarDatos() {
        val nombres = sharedPreferences.getString("nombres", "")
        val apellidos = sharedPreferences.getString("apellidos", "")
        val email = sharedPreferences.getString("email", "")
        val telefono = sharedPreferences.getString("telefono", "")

        tvNombre.text = "$nombres $apellidos"
        tvEmail.text = email
        tvTelefono.text = telefono
    }
}
