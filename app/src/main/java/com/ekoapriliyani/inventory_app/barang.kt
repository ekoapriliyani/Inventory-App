package com.ekoapriliyani.inventory_app

import java.io.Serializable

data class Barang(
    val nama: String,
    val jumlah: Int,
    val harga: Double
) : Serializable
