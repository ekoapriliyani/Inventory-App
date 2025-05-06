package com.ekoapriliyani.inventory_app

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.lang.NumberFormatException

class TambahBarangActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tambah_barang)

        val etNama = findViewById<EditText>(R.id.et_nama)
        val etJumlah = findViewById<EditText>(R.id.et_jumlah)
        val etHarga = findViewById<EditText>(R.id.et_harga)
        val btnSimpan = findViewById<Button>(R.id.btn_simpan)

        btnSimpan.setOnClickListener {
            val nama = etNama.text.toString()
            val jumlah = etJumlah.text.toString()
            val harga = etHarga.text.toString()

            if (nama.isBlank() || jumlah.isBlank() || harga.isBlank()) {
                Toast.makeText(this, "Data tidak boleh kosong", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            try {
                val barang = Barang(
                    nama = nama,
                    jumlah = jumlah.toInt(),
                    harga = harga.toDouble()
                )

                val resultIntent = intent
                resultIntent.putExtra("barang", barang)
                setResult(Activity.RESULT_OK, resultIntent)
                finish()

            } catch (e: NumberFormatException) {
                Toast.makeText(this, "Jumlah dan harga harus angka", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
