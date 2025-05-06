package com.ekoapriliyani.inventory_app

import com.ekoapriliyani.inventory_app.Barang
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class DataBarangActivity : AppCompatActivity() {
    private val REQUEST_TAMBAH = 1

    private lateinit var recyclerView: RecyclerView
    private lateinit var barangAdapter: DataBarangAdapter
    private val listBarang = mutableListOf<Barang>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_barang)

        recyclerView = findViewById(R.id.rv_barang)
        barangAdapter = DataBarangAdapter(listBarang)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = barangAdapter

        // Tombol Tambah
        findViewById<FloatingActionButton>(R.id.fab_tambah_barang).setOnClickListener {
            val intent = Intent(this, TambahBarangActivity::class.java)
            startActivityForResult(intent, REQUEST_TAMBAH)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_TAMBAH && resultCode == Activity.RESULT_OK) {
            val barang = data?.getSerializableExtra("barang") as? Barang
            barang?.let {
                listBarang.add(it)
                barangAdapter.notifyItemInserted(listBarang.size - 1)
            }
        }
    }
}
