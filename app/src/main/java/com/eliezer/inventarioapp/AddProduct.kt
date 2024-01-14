package com.eliezer.inventarioapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.eliezer.inventarioapp.data.entities.Product
import com.eliezer.inventarioapp.databinding.FragmentAddProductBinding
import com.eliezer.inventarioapp.home.HomeState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AddProduct : Fragment() {
    // TODO: Rename and change types of parameters\
    private var _binding: FragmentAddProductBinding? = null
    private val binding get() = _binding!!
    private val btSave by lazy {
        binding.btnSave
    }
    private val productViewModel by viewModels<ProductViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentAddProductBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btSave.setOnClickListener() {
            insertProduct()
        }
    }

    private fun insertProduct() {

        val product= Product(
            nombre = binding.txtName.text.toString(),
            cantidad= (binding.txtAmounth.text.toString()).toInt(),
            precio = (binding.txtPrice.text.toString()).toDouble(),
            descripcion = binding.txtDescription.text.toString()
        )
        println(product)
        productViewModel.insertProduct(product)


    }


}