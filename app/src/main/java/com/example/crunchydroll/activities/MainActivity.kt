package com.example.crunchydroll.activities

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.crunchydroll.R
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Insets del sistema (status bar, etc.)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Referencias
        drawerLayout = findViewById(R.id.main)
        val navigationView = findViewById<NavigationView>(R.id.navigation_view)
        val menuIcon = findViewById<ImageView>(R.id.menu_icon)

        // Abrir menú lateral al tocar ícono hamburguesa
        menuIcon.setOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }

        // Manejo de clics del menú lateral
        navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.menu_home -> {
                    startActivity(Intent(this, HomeActivity::class.java))
                }
                R.id.menu_perfil -> {
                    startActivity(Intent(this, PerfilActivity::class.java))
                }
                R.id.menu_cerrar_sesion -> {
                    startActivity(Intent(this, LoginActivity::class.java))
                    finish()
                }
            }

            // Cierra el drawer
            drawerLayout.closeDrawer(GravityCompat.START)
            true
        }
    }
}
