package com.eliezer.inventarioapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.eliezer.inventarioapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager.beginTransaction()
            .add(binding.navHostFragment.id, MainMenu(), null)
            .addToBackStack(null)
            .commitAllowingStateLoss()
    }




}