package com.eliezer.inventarioapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eliezer.inventarioapp.data.entities.Product
import com.eliezer.inventarioapp.data.repositories.ProductRepository
import com.eliezer.inventarioapp.home.HomeState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(private val repository: ProductRepository) :
    ViewModel() {

    private var _homeState: MutableStateFlow<HomeState> = MutableStateFlow(HomeState.Started)
    val homeState get() = _homeState.asStateFlow()

    fun insertProduct(product: Product){
        print(product)
        print("si entro")
        viewModelScope.launch{
             repository.insertProduct(product).catch {

            }.collect{

             }

        }
    }

    fun getAllProducts() {
        viewModelScope.launch {
            repository.getAllProducts().onStart {
                _homeState.emit(HomeState.Loading(showLoading = true))
            }.map {
                _homeState.emit(HomeState.Loading(showLoading = false))
                return@map it
            }.collect {
                _homeState.emit(HomeState.Sucess(it))
            }

        }
    }
}