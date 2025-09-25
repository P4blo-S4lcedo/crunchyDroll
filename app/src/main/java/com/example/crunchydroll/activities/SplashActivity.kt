package com.example.crunchydroll.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Handler
import android.os.Looper
import com.example.crunchydroll.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // Ejecuta algo despues de un tiempo
        Handler(Looper.getMainLooper()).postDelayed({
            //Intent crea un "puente" para pasar de una pantalla a la otra, es como el mensajero que le dice a android "Quiero ir de esta Activity a otra"
            val intent = Intent(this, HomeActivity::class.java)
            //Abre la nueva pantalla
            startActivity(intent)
            finish() // Cierra Splash para que no vuelva atrás
        }, 2000) // 2000 milisegundos = 2 segundos
    }
}