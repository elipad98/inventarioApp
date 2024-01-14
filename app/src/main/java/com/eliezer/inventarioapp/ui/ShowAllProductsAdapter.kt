package com.eliezer.inventarioapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.eliezer.inventarioapp.R
import com.eliezer.inventarioapp.data.entities.Product

class ShowAllProductsAdapter(private val productList:List<Product>): RecyclerView.Adapter<ShowAllProductsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShowAllProductsViewHolder {
        TODO("Not yet implemented")
        val layoutInflater = LayoutInflater.from(parent.context)
        return ShowAllProductsViewHolder(layoutInflater.inflate(R.layout.item_product,parent,false))
    }

    override fun getItemCount(): Int =productList.size

    override fun onBindViewHolder(holder: ShowAllProductsViewHolder, position: Int) {

    }
}