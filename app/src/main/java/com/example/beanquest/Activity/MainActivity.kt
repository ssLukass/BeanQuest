package com.example.beanquest.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.beanquest.Fragments.CartFragment
import com.example.beanquest.Fragments.HistoryFragment
import com.example.beanquest.Fragments.HomeFragment
import com.example.beanquest.Fragments.ProfileFragment
import com.example.beanquest.Fragments.SearchFragment
import com.example.beanquest.R
import com.example.beanquest.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var bidning : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bidning = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bidning.root)

        val bottomNavView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        val navigationView = findNavController(R.id.fragment_container)

        bottomNavView.setupWithNavController(navigationView)
    }
}