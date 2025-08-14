package com.example.crunchydroll

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val btnMain = findViewById<Button>(R.id.btnMain)
        btnMain.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}