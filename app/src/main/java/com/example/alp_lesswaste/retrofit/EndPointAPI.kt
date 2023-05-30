package com.example.alp_lesswaste.retrofit

import com.example.alp_lesswaste.model.Login
import com.example.alp_lesswaste.model.menu.MenuData
import com.example.alp_lesswaste.model.menu.MenuModel
import com.example.alp_lesswaste.model.order.OrderData
import com.example.alp_lesswaste.model.user.UserData
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface EndPointAPI {

    @GET("mahasiswa")
    suspend fun getAllUser(): Response<UserData>

    @GET("menu")
    suspend fun getAllMenu(): Response<MenuData>

    @POST("menu")
    suspend fun createMenu(@Body body: RequestBody?): ResponseBody?

    @FormUrlEncoded
    @POST("login")
    fun Login(
        @Field("username") username: String,
        @Field("password") password: String
    ): Call<Login>

    @POST("mahasiswa")
    suspend fun createUser(@Body body: RequestBody?): ResponseBody?

    @GET("order")
    suspend fun getAllOrder(): Response<OrderData>

    @POST("order")
    suspend fun createOrder(@Body body: RequestBody?): ResponseBody?
}