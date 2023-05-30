package com.example.alp_lesswaste.viewmodel

import androidx.lifecycle.ViewModel
import com.example.alp_lesswaste.repository.RestaurantRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RestaurantViewModel @Inject constructor(
    private val repository: RestaurantRepository): ViewModel() {
}