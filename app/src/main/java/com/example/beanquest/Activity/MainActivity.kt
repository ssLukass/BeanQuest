package com.example.beanquest.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.beanquest.R
import com.example.beanquest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var bidning : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bidning = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bidning.root)

        val bottomNavView = bidning.bottomNavigationView
        val navigationView = findNavController(R.id.fragment_container)

        bottomNavView.setupWithNavController(navigationView)
    }
}