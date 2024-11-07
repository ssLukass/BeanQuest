package com.example.beanquest.Activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import com.example.beanquest.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class SplashActivity : AppCompatActivity() {

    private lateinit var videoView: VideoView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        videoView = findViewById(R.id.videoView)
        val videoUri = Uri.parse("android.resource://" + packageName + "/" + R.raw.beann)
        videoView.setVideoURI(videoUri)



        videoView.setZOrderOnTop(true)
        videoView.setOnPreparedListener { mediaPlayer ->
            mediaPlayer.isLooping = false //
            videoView.start()
        }

        // Устанавливаем таймер на 6 секунд для перехода к следующему экрану
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, LoginUserActivity::class.java))
            finish()
        }, 6000)
    }
}
