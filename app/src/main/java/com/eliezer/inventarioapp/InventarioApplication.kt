package com.eliezer.inventarioapp

import android.app.Application
import androidx.room.Room
import com.eliezer.inventarioapp.data.db.DbProduct
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class InventarioApplication:Application() {
}