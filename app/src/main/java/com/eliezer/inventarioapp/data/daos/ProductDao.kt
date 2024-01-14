package com.eliezer.inventarioapp.data.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.eliezer.inventarioapp.data.entities.Product
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {

    @Query("SELECT * FROM product where nombre=:name ")
    fun getOne(name:String):Flow<Product>

    @Query("SELECT * FROM product")
    fun getAll(): Flow<List<Product>>

    @Insert
    fun insert(product :Product)

    @Delete
    fun delete(product: Product)
}