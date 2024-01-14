package com.eliezer.inventarioapp.di

import android.content.Context
import androidx.room.Room
import com.eliezer.inventarioapp.data.daos.ProductDao
import com.eliezer.inventarioapp.data.db.DbProduct
import com.eliezer.inventarioapp.data.repositories.ProductRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideProductsRepository(productDao: ProductDao): ProductRepository {
        return ProductRepository(productDao)
    }

    @Provides
    @Singleton
    fun provideProductDao(dbProduct: DbProduct): ProductDao {
        return dbProduct.productDao()
    }

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext applicationContext: Context):
        DbProduct {
        return Room.databaseBuilder(
            applicationContext,
            DbProduct::class.java,
            "products-db"
        )
            .build()
    }
}