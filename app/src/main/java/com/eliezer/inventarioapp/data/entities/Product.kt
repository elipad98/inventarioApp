package com.eliezer.inventarioapp.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Product")
data class Product(
    @PrimaryKey(autoGenerate = true)
    var id : Int =0,
    var nombre: String,
    var precio: Double,
    var cantidad: Int,
    var descripcion: String
)