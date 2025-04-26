package com.ekoapriliyani.inventory_app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {

    private lateinit var btnDataBarang: Button
    private lateinit var btnTambahBarang: Button
    private lateinit var btnTransaksi: Button
    private lateinit var btnLogout: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        btnDataBarang = findViewById(R.id.btn_data_barang)
        btnTambahBarang = findViewById(R.id.btn_tambah_barang)
        btnTransaksi = findViewById(R.id.btn_transaksi)
        btnLogout = findViewById(R.id.btn_logout)

        btnDataBarang.setOnClickListener {
            val intent = Intent(this, DataBarangActivity::class.java)
            startActivity(intent)
        }

        btnTambahBarang.setOnClickListener {
            val intent = Intent(this, TambahBarangActivity::class.java)
            startActivity(intent)
        }

        btnTransaksi.setOnClickListener {
            val intent = Intent(this, TransaksiActivity::class.java)
            startActivity(intent)
        }

        btnLogout.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish()
        }
    }
}