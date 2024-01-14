package com.eliezer.inventarioapp.data.db
import androidx.room.Database
import androidx.room.RoomDatabase
import com.eliezer.inventarioapp.data.daos.ProductDao
import com.eliezer.inventarioapp.data.entities.Product

@Database(entities = arrayOf(Product::class), version = 1)
abstract class DbProduct:RoomDatabase() {
    abstract fun productDao():ProductDao

}