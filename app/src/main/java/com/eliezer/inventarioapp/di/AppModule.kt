package com.eliezer.inventarioapp.di

import com.eliezer.inventarioapp.data.repositories.ProductRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideProductsRepository(): ProductRepository{
        return ProductRepository()
    }
}