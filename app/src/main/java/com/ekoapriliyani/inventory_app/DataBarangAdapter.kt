package com.ekoapriliyani.inventory_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DataBarangAdapter(private val listBarang: List<Barang>) :
    RecyclerView.Adapter<DataBarangAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvNama: TextView = itemView.findViewById(R.id.tv_nama_barang)
        val tvJumlah: TextView = itemView.findViewById(R.id.tv_jumlah_barang)
        val tvHarga: TextView = itemView.findViewById(R.id.tv_harga_barang)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_barang, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = listBarang.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val barang = listBarang[position]
        holder.tvNama.text = barang.nama
        holder.tvJumlah.text = "Jumlah: ${barang.jumlah}"
        holder.tvHarga.text = "Harga: Rp ${barang.harga}"
    }
}
