package com.example.alp_lesswaste.repository

import com.example.alp_lesswaste.retrofit.EndPointAPI
import okhttp3.MultipartBody
import okhttp3.RequestBody
import javax.inject.Inject

class MenuRepository @Inject constructor(private val api: EndPointAPI){

    suspend fun getMenu() =
        api.getAllMenu()

//    suspend fun updateschedule()



    suspend fun createMenu(
        menu_name: String,
        menu_price: String,
        menu_desc: String,
    ){
        val requestBody: RequestBody = MultipartBody.Builder()
            .setType(MultipartBody.FORM)
            .addFormDataPart("menu_name", menu_name)
            .addFormDataPart("menu_price", menu_price)
            .addFormDataPart("menu_desc", menu_desc)
            .build()

        api.createMenu(requestBody)
    }

}