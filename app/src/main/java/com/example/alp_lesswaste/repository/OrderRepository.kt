package com.example.alp_lesswaste.repository

import com.example.alp_lesswaste.retrofit.EndPointAPI
import okhttp3.MultipartBody
import okhttp3.RequestBody
import javax.inject.Inject

class OrderRepository @Inject constructor(private val api: EndPointAPI) {
    suspend fun getOrder() =
        api.getAllOrder()

//    suspend fun updateschedule()



    suspend fun createOrder(
        order_name: String,
        order_quantity: String,
        order_phonenumber: String,
    ){
        val requestBody: RequestBody = MultipartBody.Builder()
            .setType(MultipartBody.FORM)
            .addFormDataPart("order_name", order_name)
            .addFormDataPart("order_quantity", order_quantity)
            .addFormDataPart("order_phonenumber", order_phonenumber)
            .build()

        api.createOrder(requestBody)
    }
}