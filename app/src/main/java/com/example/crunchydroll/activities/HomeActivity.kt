package com.example.crunchydroll.activities

import android.os.Bundle
import android.content.Intent

import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.crunchydroll.R

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        //Busca el boton en el XML
        val btnLogin = findViewById<Button>(R.id.startButton)
        //Define la acción de el clic
        btnLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        val textRegister = findViewById<TextView>(R.id.registerText)
        textRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}