package com.example.beanquest.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import com.example.beanquest.R

class StartActivity : AppCompatActivity() {

     private lateinit var goLoginPage: AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        goLoginPage = findViewById(R.id.go_user_login_btn)

        goLoginPage.setOnClickListener{
            val intent = Intent(this@StartActivity, LoginUserActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}