package com.example.nhcare
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

    class LoginActivity : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.login)

            val editTextUsername = findViewById<EditText>(R.id.editTextUsername)
            val editTextPassword = findViewById<EditText>(R.id.editTextPassword)
            val buttonLogin = findViewById<Button>(R.id.buttonLogin)

            buttonLogin.setOnClickListener {
                val username = editTextUsername.text.toString()
                val password = editTextPassword.text.toString()

                if (username == "user" && password == "password") {
                    // Login berhasil, alihkan ke halaman utama
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    // Login gagal, tampilkan pesan kesalahan
                    Toast.makeText(this, "Login gagal. Periksa username dan password.", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
