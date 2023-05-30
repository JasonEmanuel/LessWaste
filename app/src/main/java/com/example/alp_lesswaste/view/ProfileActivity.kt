package com.example.alp_lesswaste.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.alp_lesswaste.databinding.ActivityProfileBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()


        binding.backButtonImageButton.setOnClickListener {
            finish()
        }

        binding.logoutButton.setOnClickListener {
            MaterialAlertDialogBuilder(this)
                .setTitle("Logout")
                .setMessage("Are you sure you want to logout?")
                .setNegativeButton("Cancel") {dialog, which ->
                }
                .setPositiveButton("Logout") {dialog, which ->
                    val myIntent = Intent(this, LoginActivity::class.java)
                    Toast.makeText(baseContext, "Logout Successful", Toast.LENGTH_SHORT).show()
                    startActivity(myIntent)
                    finish()
                }
                .show()
        }
    }
}