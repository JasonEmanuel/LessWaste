package com.example.alp_lesswaste.model.order

import com.example.alp_lesswaste.model.menu.MenuModel

class OrderData(
    val `data`: List<OrderModel>,
    val message: String,
    val status: Int
)