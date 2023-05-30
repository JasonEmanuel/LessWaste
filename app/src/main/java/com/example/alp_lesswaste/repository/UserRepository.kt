package com.example.alp_lesswaste.repository

import com.example.alp_lesswaste.retrofit.EndPointAPI
import okhttp3.MultipartBody
import okhttp3.RequestBody
import javax.inject.Inject


class UserRepository @Inject constructor(private val api:EndPointAPI) {

    suspend fun getAllUserData() = api.getAllUser()

    fun LoginUser(
        username: String,
        password: String,
    ) = api.Login(username, password)


    suspend fun createUser(
        username: String,
        password: String,
        status: String
    ){
        val requestBody: MultipartBody = MultipartBody.Builder()
            .setType(MultipartBody.FORM)
            .addFormDataPart("username", username)
            .addFormDataPart("password", password)
            .addFormDataPart("status", status)
            .build()

        api.createUser(requestBody)
    }
}