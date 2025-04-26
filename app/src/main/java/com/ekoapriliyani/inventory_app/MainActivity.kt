package com.ekoapriliyani.inventory_app

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
//import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

import android.os.Handler
import android.os.Looper
import android.widget.*

class MainActivity : AppCompatActivity() {
    // Deklarasi variabel
    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnLogin: Button
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etEmail = findViewById(R.id.et_email)
        etPassword = findViewById(R.id.et_password)
        btnLogin = findViewById(R.id.btn_login)
        progressBar = findViewById(R.id.progress_bar)

        btnLogin.setOnClickListener {
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()

            if (email.isEmpty()) {
                etEmail.error = "Email tidak boleh kosong"
                etEmail.requestFocus()
                return@setOnClickListener
            }

            if (password.isEmpty()) {
                etPassword.error = "Password tidak boleh kosong"
                etPassword.requestFocus()
                return@setOnClickListener
            }

            // Tampilkan loading
            progressBar.visibility = ProgressBar.VISIBLE
            btnLogin.isEnabled = false

            // Simulasi loading 2 detik pakai Handler
            Handler(Looper.getMainLooper()).postDelayed({

                progressBar.visibility = ProgressBar.GONE
                btnLogin.isEnabled = true

                if (email == "admin@example.com" && password == "123456") {
                    Toast.makeText(this, "Login Berhasil", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, HomeActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(this, "Email atau Password salah", Toast.LENGTH_SHORT).show()
                }

            }, 2000) // 2 detik delay
        }
    }
}