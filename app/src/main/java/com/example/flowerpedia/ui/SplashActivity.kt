package com.example.flowerpedia.ui

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AccelerateDecelerateInterpolator
import android.widget.ImageView
import com.example.flowerpedia.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val logo = findViewById<ImageView>(R.id.logo)

        val scaleX = PropertyValuesHolder.ofFloat(ImageView.SCALE_X, 1.0f, 1.2f, 1.0f)
        val scaleY = PropertyValuesHolder.ofFloat(ImageView.SCALE_Y, 1.0f, 1.2f, 1.0f)
        val animator = ObjectAnimator.ofPropertyValuesHolder(logo, scaleX, scaleY)
        animator.duration = 2000
        animator.repeatCount = ObjectAnimator.INFINITE
        animator.repeatMode = ObjectAnimator.RESTART
        animator.interpolator = AccelerateDecelerateInterpolator()
        animator.start()

        //Delay for 3 seconds before transitioning to MainActivity
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }
}