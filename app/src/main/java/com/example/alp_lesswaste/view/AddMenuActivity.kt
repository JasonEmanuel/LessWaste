package com.example.alp_lesswaste.view

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModelProvider
import com.example.alp_lesswaste.R
import com.example.alp_lesswaste.databinding.ActivityAddMenuBinding
import com.example.alp_lesswaste.databinding.ActivityRestaurantBinding
import com.example.alp_lesswaste.retrofit.AppModule
import com.example.alp_lesswaste.retrofit.EndPointAPI
import com.example.alp_lesswaste.viewmodel.MenuViewModel
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@AndroidEntryPoint
class AddMenuActivity : AppCompatActivity() {
    private val api by lazy { AppModule }
    private lateinit var menu: MenuViewModel
    private lateinit var binding: ActivityAddMenuBinding

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_menu)
        binding = ActivityAddMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonSave.setOnClickListener{
            val menu_name = binding.menuName.text.toString()
            val menu_price = binding.menuPrice.text.toString()
            val menu_desc = binding.menuDesc.text.toString()


            if (menu_name.isEmpty() || menu_price.isEmpty() || menu_desc.isEmpty()){
                Toast.makeText(this, "Please Enter required field", Toast.LENGTH_LONG).show()
            }else{
                menu = ViewModelProvider(this)[MenuViewModel::class.java]

                menu.state = menu.state.copy(
                    menu_name = menu_name,
                    menu_price = menu_price,
                    menu_desc = menu_desc,
                )
                menu.createMenu()
                val intent = Intent(this, RestaurantActivity::class.java)
                startActivity(intent)
                finish()
            }

        }
    }
}