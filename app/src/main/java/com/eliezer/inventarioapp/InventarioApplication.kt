package com.eliezer.inventarioapp

import android.app.Application
import androidx.room.Room
import com.eliezer.inventarioapp.data.db.DbProduct
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class InventarioApplication:Application() {
    companion object{
        lateinit var database: DbProduct
    }
    override fun onCreate(){
        super.onCreate()
        database = Room.databaseBuilder(this, DbProduct::class.java,"products-db").build()

    }
}