package com.example.alp_lesswaste.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.alp_lesswaste.adapter.MenuAdapter
import com.example.alp_lesswaste.adapter.OrderAdapter
import com.example.alp_lesswaste.databinding.ActivityRestaurantBinding
import com.example.alp_lesswaste.viewmodel.MenuViewModel
import com.example.alp_lesswaste.viewmodel.OrderViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class   RestaurantActivity : AppCompatActivity() {

    private lateinit var binding:ActivityRestaurantBinding
    private lateinit var adaptermenu: MenuAdapter
    private lateinit var adapterorder: OrderAdapter
    private lateinit var viewModelmenu: MenuViewModel
    private lateinit var viewModelorder: OrderViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRestaurantBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModelorder = ViewModelProvider(this).get(OrderViewModel::class.java)
        viewModelorder.getAllOrder()
        viewModelorder.dataorder.observe(this,  Observer{ response ->
            binding.listorderRv.layoutManager = LinearLayoutManager(this)
            adapterorder = OrderAdapter(response)
            binding.listorderRv.adapter = adapterorder
        })

        viewModelmenu = ViewModelProvider(this).get(MenuViewModel::class.java)
        viewModelmenu.getAllMenu()

        binding.usernameRestoPageTv.text = "Welcome, "

        viewModelmenu.datamenu.observe(this,  Observer{ response ->
            binding.listUserRv.layoutManager = LinearLayoutManager(this)
            adaptermenu = MenuAdapter(response)
            binding.listUserRv.adapter = adaptermenu
        })

        binding.addMenuFloatingActionButton.setOnClickListener {
            val myIntent = Intent(this, AddMenuActivity::class.java)
            startActivity(myIntent)
        }


        binding.restoProfileImageView.setOnClickListener {
            val myIntent = Intent(this, ProfileActivity::class.java)
            startActivity(myIntent)
        }
    }


}