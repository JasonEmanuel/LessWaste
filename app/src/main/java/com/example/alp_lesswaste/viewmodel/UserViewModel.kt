package com.example.alp_lesswaste.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.alp_lesswaste.model.user.UserModel
import com.example.alp_lesswaste.model.user.UserState
import com.example.alp_lesswaste.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(private val repository: UserRepository): ViewModel(){

    var state by mutableStateOf(UserState())

    val _user: MutableLiveData<ArrayList<UserModel>> by lazy {
        MutableLiveData<ArrayList<UserModel>>()
    }

    val datauser: LiveData<ArrayList<UserModel>>
    get() = _user

    fun Login(username: String, password: String) = repository.LoginUser(username, password)


    fun getAllUserData() = viewModelScope.launch {
        repository.getAllUserData().let { response ->
            if (response.isSuccessful){
                _user.postValue(response.body()?.data as ArrayList<UserModel>?)
            }else {
                Log.e("Get Data", "Failed!")
            }
        }
    }

    fun addUser() = viewModelScope.launch {
        repository.createUser(
            username = state.username,
            password = state.password,
            status = state.status
        )
    }
}
