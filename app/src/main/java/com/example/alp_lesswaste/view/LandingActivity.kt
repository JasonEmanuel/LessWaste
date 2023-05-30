package com.example.alp_lesswaste.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.alp_lesswaste.R
import com.example.alp_lesswaste.databinding.ActivityLandingBinding

class LandingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLandingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing)
        binding = ActivityLandingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

       binding.nextButton.setOnClickListener{
           val myIntent = Intent(this, UserActivity::class.java)
           startActivity(myIntent)
        }
        binding.login.setOnClickListener{
            val myIntent = Intent(this, LoginActivity::class.java)
            startActivity(myIntent)
        }
    }
}