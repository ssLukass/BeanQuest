package com.example.beanquest.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.beanquest.databinding.ActivitySingUpUserBinding

class SingUpUserActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySingUpUserBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySingUpUserBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnRegister.setOnClickListener{
            val intent = Intent(this@SingUpUserActivity, LocationActivity::class.java)
            startActivity(intent)
        }

        binding.iHaveAccount.setOnClickListener{
            val intent = Intent(this@SingUpUserActivity, LoginUserActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}