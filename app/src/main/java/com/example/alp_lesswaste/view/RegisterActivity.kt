package com.example.alp_lesswaste.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.alp_lesswaste.databinding.ActivityRegisterBinding
import com.example.alp_lesswaste.repository.UserRepository
import com.example.alp_lesswaste.retrofit.AppModule
import com.example.alp_lesswaste.viewmodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterActivity : AppCompatActivity() {

    private val api by lazy { AppModule }
    private lateinit var binding: ActivityRegisterBinding
    private lateinit var user: UserViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.backLoginTv.setOnClickListener {
            val myIntent = Intent(this, LoginActivity::class.java)
            startActivity(myIntent)
        }

        Listener()
    }

    private fun Listener(){
        binding.buttonCreate.setOnClickListener {
            var username = binding.registerUsernameTextInputLayout.editText?.text.toString().trim()
            var password = binding.registerPasswordTextInputLayout.editText?.text.toString().trim()

            user = ViewModelProvider(this)[UserViewModel::class.java]
            user.state = user.state.copy(
                username = username,
                password = password
            )
            user.addUser()
            val myIntent = Intent(this, LoginActivity::class.java)
            startActivity(myIntent)
            finish()
            Checker()
        }
    }

    private fun Checker(){
        var isCompleted = true

            if (binding.registerUsernameTextInput.text.toString().isEmpty()){
                binding.registerUsernameTextInputLayout.error = "Nama masih kosong"
                isCompleted = false
            }else{
                binding.registerUsernameTextInputLayout.error = ""
            }

            if (binding.editTextTextPassword2.text.toString().isEmpty()){
                binding.registerPasswordTextInputLayout.error = "Password masih kosong"
                isCompleted = false
            }else{
                if (binding.editTextTextPassword2.text.toString().length < 8){
                    binding.registerPasswordTextInputLayout.error = "Password too short"
                    isCompleted = false
                }else if (binding.editTextTextPassword2.text.toString().matches(".*[a-z].*".toRegex())){
                    binding.registerPasswordTextInputLayout.error = "Password tidak ada huruf kecil"
                    isCompleted = false
                }else if (binding.editTextTextPassword2.text.toString().matches(".*[A-Z].*".toRegex())){
                    binding.registerPasswordTextInputLayout.error = "Password tidak ada huruf besar"
                    isCompleted = false
                }else {
                    binding.registerPasswordTextInputLayout.error = ""
                }
            }

        if (isCompleted){
            val myIntent = Intent(this, LoginActivity::class.java)
            Toast.makeText(this, "Account Created", Toast.LENGTH_LONG).show()
            startActivity(myIntent)
        }
    }
}