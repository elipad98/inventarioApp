package com.eliezer.inventarioapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.eliezer.inventarioapp.databinding.FragmentShowAllProductsBinding
import com.eliezer.inventarioapp.home.HomeState
import com.eliezer.inventarioapp.ui.ShowAllProductsAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


@AndroidEntryPoint
class ShowAllProducts : Fragment() {
    // TODO: Rename and change types of parameters
    private var _binding:FragmentShowAllProductsBinding?=null
    private val binding  get() = _binding!!
    private val productViewModel by viewModels<ProductViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding= FragmentShowAllProductsBinding.inflate(inflater,container, false)
        val view = binding.root
        lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                productViewModel.homeState.collect(::initRecycleView)
            }
        }
        return view
    }
    private fun initRecycleView(state:HomeState){
        binding.listProducts.layoutManager = LinearLayoutManager(this.context)
        when(state){
            is Error ->{
                Toast.makeText(this.context,"Ocurrio un error",Toast.LENGTH_SHORT)
            }
            is HomeState.Loading ->{

            }
            is HomeState.Sucess->{
                binding.listProducts.adapter=ShowAllProductsAdapter(state.products)
            }
            else->{}
        }


    }

}