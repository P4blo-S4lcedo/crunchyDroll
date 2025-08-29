package com.example.crunchydroll

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.os.PersistableBundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    private lateinit var SharedPreferences : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val textLogin = findViewById<TextView>(R.id.returnLogin)
        textLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)

        }

        SharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE)

        setUpOnClickListeners()
    }

    public fun setUpOnClickListeners(){
        val etNombres = findViewById<EditText>(R.id.inputFirstName)
        val etApellidos = findViewById<EditText>(R.id.inputLastName)
        val etEmail = findViewById<EditText>(R.id.textEmail)
        val etNumero = findViewById<EditText>(R.id.textPhone)
        val etContraseña = findViewById<EditText>(R.id.textPassword)
        val etContraseña2 = findViewById<EditText>(R.id.textPassword2)

        val btnRegistro = findViewById<Button>(R.id.registerButton)

        btnRegistro.setOnClickListener {
            val nombres = etNombres.text.toString().trim()
            val apellidos = etApellidos.text.toString().trim()
            val email = etEmail.text.toString().trim()
            val telefono = etNumero.text.toString().trim()
            val contraseña = etContraseña.text.toString()
            val contraseña2 = etContraseña2.text.toString()

            if (validarCampos(nombres, apellidos, email, telefono, contraseña, contraseña2)) {
                guardarDatos(nombres, apellidos, email, telefono, contraseña, contraseña2)

                Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show()

                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }

    private fun validarCampos(nombres: String, apellidos: String, email: String, telefono: String, contraseña: String, contraseña2: String): Boolean {
        if (nombres.isEmpty()) {
            Toast.makeText(this, "Por favor ingrese su nombre(s)", Toast.LENGTH_SHORT).show()
            return false
        }

        if (apellidos.isEmpty()) {
            Toast.makeText(this, "Por favor ingrese su apellido(s)", Toast.LENGTH_SHORT).show()
            return false
        }
        if (email.isEmpty()) {
            Toast.makeText(this, "Por favor ingrese su correo electrónico", Toast.LENGTH_SHORT)
                .show()
            return false
        }
        if (telefono.isEmpty()) {
            Toast.makeText(this, "Por favor ingrese su teléfono", Toast.LENGTH_SHORT).show()
            return false
        }
        if (contraseña.isEmpty()) {
            Toast.makeText(this, "Por favor ingrese su contraseña", Toast.LENGTH_SHORT).show()
            return false
        }
        if (contraseña2.isEmpty()) {
            Toast.makeText(this, "Por favor confirme su contraseña", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }

    private fun guardarDatos(nombres: String, apellidos: String, email: String, telefono: String, contraseña: String, contraseña2: String) {
        val editor = SharedPreferences.edit()
        editor.putString("nombres",nombres)
        editor.putString("apellidos",apellidos)
        editor.putString("email",email)
        editor.putString("telefono",telefono)
        editor.putString("contrasela",contraseña)
        editor.putString("contraseña2",contraseña2)
        editor.apply()

    }
}