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
import com.example.alp_lesswaste.repository.MenuRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import java.util.ArrayList

@HiltViewModel
class MenuViewModel @Inject constructor(private val repository: MenuRepository): ViewModel() {


    var state by mutableStateOf(MenuState())



    val _menu: MutableLiveData<ArrayList<MenuModel>> by lazy {
        MutableLiveData<ArrayList<MenuModel>>()
    }

    val datamenu: LiveData<ArrayList<MenuModel>>
        get() = _menu

    fun getAllMenu() = viewModelScope.launch {
        repository.getMenu().let { response ->
            if( response.isSuccessful){
                _menu.postValue(response.body()?.data as ArrayList<MenuModel>?)
            }else{
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

    fun createMenu() = viewModelScope.launch{
        repository.createMenu(
            menu_name = state.menu_name,
            menu_price = state.menu_price,
            menu_desc = state.menu_desc,
        )
    }



}