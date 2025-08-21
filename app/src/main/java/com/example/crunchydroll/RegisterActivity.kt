package com.example.crunchydroll

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.os.PersistableBundle
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val textLogin = findViewById<TextView>(R.id.textView14)
        textLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        val btnRegistrarse = findViewById<Button>(R.id.button2)
        btnRegistrarse.setOnClickListener {
            mostrarDialogoTerminos()
        }
    }



    private fun mostrarDialogoTerminos() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Términos y Condiciones")
        builder.setMessage("¿Aceptas los términos y condiciones para continuar?")

        builder.setPositiveButton("Sí, acepto") { dialog, _ ->
            // Redirigir al Login
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish() // Opcional: para cerrar la pantalla de registro
            dialog.dismiss()
        }

        builder.setNegativeButton("No") { dialog, _ ->
            // No hace nada, solo cierra el diálogo
            dialog.dismiss()
        }

        builder.setCancelable(false) // Evita que se cierre tocando afuera
        val dialog = builder.create()
        dialog.show()
    }
}