package com.example.alp_lesswaste.view

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModelProvider
import com.example.alp_lesswaste.R
import com.example.alp_lesswaste.databinding.ActivityAddOrderBinding
import com.example.alp_lesswaste.retrofit.AppModule
import com.example.alp_lesswaste.viewmodel.MenuViewModel
import com.example.alp_lesswaste.viewmodel.OrderViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddOrderActivity : AppCompatActivity() {
    private val api by lazy { AppModule }
    private lateinit var order: OrderViewModel
    private lateinit var binding: ActivityAddOrderBinding

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_order)
        binding = ActivityAddOrderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonSave.setOnClickListener{
            val menu_name = binding.menuName.text.toString()
            val menu_price = binding.menuPrice.text.toString()
            val menu_desc = binding.menuDesc.text.toString()


            if (menu_name.isEmpty() || menu_price.isEmpty() || menu_desc.isEmpty()){
                Toast.makeText(this, "Please Enter required field", Toast.LENGTH_LONG).show()
            }else{
                order = ViewModelProvider(this)[OrderViewModel::class.java]

                order.state = order.state.copy(
                    order_name = menu_name,
                    order_quantity = menu_price,
                    order_phonenumber = menu_desc,
                )
                order.createOrder()
                val intent = Intent(this, UserActivity::class.java)
                startActivity(intent)
                Toast.makeText(this, "Order Added!", Toast.LENGTH_LONG).show()
                finish()
            }

        }
    }
}