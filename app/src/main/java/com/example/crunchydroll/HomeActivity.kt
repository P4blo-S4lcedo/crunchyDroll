package com.example.crunchydroll

import android.os.Bundle
import android.content.Intent

import android.os.PersistableBundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        //Busca el boton en el XML
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        //Define la acción de el clic
        btnLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}