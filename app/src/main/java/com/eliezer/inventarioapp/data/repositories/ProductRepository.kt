package com.eliezer.inventarioapp.data.repositories

import com.eliezer.inventarioapp.data.daos.ProductDao
import com.eliezer.inventarioapp.data.entities.Product
import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

@ActivityRetainedScoped
class ProductRepository @Inject constructor(private val productDao: ProductDao) {
    fun getOneProduct(name: String): Flow<Product> {
        return productDao.getOne(name)
    }

    fun getAllProducts(): Flow<List<Product>> =
        productDao.getAll()

    suspend fun insertProduct(product: Product): Flow<Boolean> =
        flow {
            print("mensaje antes de insert")
            val insertProd = productDao.insert(product)
            println(insertProd)
            emit(true)
        }.flowOn(Dispatchers.IO)


}