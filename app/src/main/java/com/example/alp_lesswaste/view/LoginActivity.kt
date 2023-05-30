package com.example.alp_lesswaste.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.alp_lesswaste.databinding.ActivityLoginBinding
import com.example.alp_lesswaste.model.Login
import com.example.alp_lesswaste.viewmodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var viewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.registerHereTv.setOnClickListener {
            val myIntent = Intent(this, RegisterActivity::class.java)
            startActivity(myIntent)
        }

        GetIntent()
        Listener()
    }


    private fun GetIntent() {
        val display1 = intent.getStringExtra("display")
        val display2 = intent.getStringExtra("displaysignup")
        val display3 = intent.getStringExtra("displaydelete")

        if (display1 != null) {
            Toast.makeText(this, display1, Toast.LENGTH_LONG).show()
        }
        if (display2 != null) {
            Toast.makeText(this, display2, Toast.LENGTH_LONG).show()
        }
        if (display3 != null) {
            Toast.makeText(this, display3, Toast.LENGTH_LONG).show()
        }
    }

    private fun Listener() {

        binding.buttonLogin.setOnClickListener {
            val username = binding.editTextUsernameLoginTv.text.toString()
            val password = binding.editTextTextPassword.text.toString()

            viewModel = ViewModelProvider(this)[UserViewModel::class.java]
            viewModel.Login(username, password).enqueue(object : Callback<Login> {
                override fun onResponse(call: Call<Login>, response: Response<Login>) {
                    if (response.isSuccessful != null) {
                        val myIntent = Intent(this@LoginActivity, RestaurantActivity::class.java)
//                        Toast.makeText(this@LoginActivity, response.body()?.id, Toast.LENGTH_LONG)
//                            .show()
                        intent.putExtra("login_id", response.body()?.id?.toIntOrNull())
                        startActivity(myIntent)
//                        Toast.makeText(this@LoginActivity, "Login Success", Toast.LENGTH_SHORT)
//                            .show()
                        finish()
                    } else {
                        Toast.makeText(this@LoginActivity, "Login Failed", Toast.LENGTH_SHORT)
                            .show()
                    }
                }

                override fun onFailure(call: Call<Login>, t: Throwable) {
                    Log.d("Login", "onFailure: ${t.message}")
                }
            })
        }
    }
}

