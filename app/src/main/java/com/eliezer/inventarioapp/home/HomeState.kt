package com.eliezer.inventarioapp.home

import com.eliezer.inventarioapp.data.entities.Product

sealed class HomeState {
    data class Loading(val showLoading: Boolean) : HomeState()

    data class Sucess(val products: List<Product>) : HomeState()

    data object Error : HomeState()

    data object Started : HomeState()
}