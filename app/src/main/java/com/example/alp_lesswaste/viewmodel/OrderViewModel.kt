package com.example.alp_lesswaste.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.alp_lesswaste.model.menu.MenuModel
import com.example.alp_lesswaste.model.menu.MenuState
import com.example.alp_lesswaste.model.order.OrderModel
import com.example.alp_lesswaste.model.order.OrderState
import com.example.alp_lesswaste.repository.MenuRepository
import com.example.alp_lesswaste.repository.OrderRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.ArrayList
import javax.inject.Inject

@HiltViewModel
class OrderViewModel @Inject constructor(private val repository: OrderRepository): ViewModel() {

    var state by mutableStateOf(OrderState())


    val _order: MutableLiveData<ArrayList<OrderModel>> by lazy {
        MutableLiveData<ArrayList<OrderModel>>()
    }

    val dataorder: LiveData<ArrayList<OrderModel>>
        get() = _order

    fun getAllOrder() = viewModelScope.launch {
        repository.getOrder().let { response ->
            if (response.isSuccessful) {
                _order.postValue(response.body()?.data as ArrayList<OrderModel>?)
            } else {
                Log.e("Get Data", "Failed!")
            }
        }
    }

//    fun getSchedule(schedule: Int) = viewModelScope.launch {
//        repository.getSchedule().let { response ->
//            if( response.isSuccessful){
//                _schedule.postValue(response.body()?.data as ArrayList<Data>)
//            }else{
//                Log.e("Get Data", "Failed!")
//            }
//        }
//    }

    fun createOrder() = viewModelScope.launch {
        repository.createOrder(
            order_name = state.order_name,
            order_quantity = state.order_quantity,
            order_phonenumber = state.order_phonenumber,
        )
    }
}