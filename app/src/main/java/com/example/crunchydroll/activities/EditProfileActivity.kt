package com.example.crunchydroll.activities

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.crunchydroll.R

class EditProfileActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)

        sharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE)

        val etNombre = findViewById<EditText>(R.id.editFirstName)
        val etApellido = findViewById<EditText>(R.id.editLastName)
        val etEmail = findViewById<EditText>(R.id.editEmail)
        val etTelefono = findViewById<EditText>(R.id.editPhone)
        val etContrasena = findViewById<EditText>(R.id.editPassword)
        val btnGuardar = findViewById<Button>(R.id.saveButton)

        // Cargar datos actuales
        etNombre.setText(sharedPreferences.getString("nombres", ""))
        etApellido.setText(sharedPreferences.getString("apellidos", ""))
        etEmail.setText(sharedPreferences.getString("email", ""))
        etTelefono.setText(sharedPreferences.getString("telefono", ""))
        etContrasena.setText(sharedPreferences.getString("contrasena", ""))

        // Guardar cambios
        btnGuardar.setOnClickListener {
            val editor = sharedPreferences.edit()
            editor.putString("nombres", etNombre.text.toString())
            editor.putString("apellidos", etApellido.text.toString())
            editor.putString("email", etEmail.text.toString())
            editor.putString("telefono", etTelefono.text.toString())
            editor.putString("contrasena", etContrasena.text.toString())
            editor.apply()

            Toast.makeText(this, "Datos actualizados", Toast.LENGTH_SHORT).show()
            finish() // Cierra esta activity y vuelve a la anterior
        }
    }
}
