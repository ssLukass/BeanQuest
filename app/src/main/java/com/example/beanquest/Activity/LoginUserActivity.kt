package com.example.beanquest.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.beanquest.databinding.ActivityLoginUserBinding

class LoginUserActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginUserBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.login.setOnClickListener{
            val intent = Intent(this@LoginUserActivity, MainActivity::class.java)
            startActivity(intent)
        }

        binding.goSingUpUser.setOnClickListener{
            val intent = Intent(this@LoginUserActivity, SingUpUserActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}