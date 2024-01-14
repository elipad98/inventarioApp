package com.eliezer.inventarioapp.ui

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.eliezer.inventarioapp.data.entities.Product
import com.eliezer.inventarioapp.databinding.ItemProductBinding

class ShowAllProductsViewHolder(view:View):RecyclerView.ViewHolder(view) {
     val binding = ItemProductBinding.bind(view)
    fun render(product:Product){
        binding.txtnombre.text=product.nombre
        binding.txtprecio.text=product.precio.toString()
        binding.txtcantidad.text=product.cantidad.toString()
        binding.txtdescripcion.text=product.descripcion
    }
}