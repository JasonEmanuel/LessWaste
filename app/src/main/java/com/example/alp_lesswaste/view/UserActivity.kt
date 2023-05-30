package com.example.alp_lesswaste.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.alp_lesswaste.adapter.MenuAdapter
import com.example.alp_lesswaste.adapter.MenuHomeAdapter
import com.example.alp_lesswaste.databinding.ActivityRestaurantBinding
import com.example.alp_lesswaste.databinding.ActivityUserBinding
import com.example.alp_lesswaste.viewmodel.MenuViewModel
import com.example.alp_lesswaste.viewmodel.OrderViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserActivity : AppCompatActivity() {

    private lateinit var adapter: MenuHomeAdapter
    private lateinit var viewModel: MenuViewModel
    private lateinit var binding:ActivityUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

            viewModel = ViewModelProvider(this).get(MenuViewModel::class.java)
            viewModel.getAllMenu()

            binding.usernamePageUserTv.text = "Welcome!"

            viewModel.datamenu.observe(this,  Observer{ response ->
                binding.listorderRv.layoutManager = LinearLayoutManager(this)
                adapter = MenuHomeAdapter(response)
                binding.listorderRv.adapter = adapter
            })

    }
}