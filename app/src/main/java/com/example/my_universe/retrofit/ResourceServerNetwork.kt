package com.example.my_universe.retrofit

import com.example.my_universe.model.RequestResultVO
import com.example.my_universe.model.User
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Query

interface ResourceServerNetwork {
    @POST("user/register")
    fun doRegister(
        @Body user: User
    ): retrofit2.Call<RequestResultVO>
    @POST("user/login")
    fun doLogin(
        @Body user: User
    ): retrofit2.Call<RequestResultVO>
    @POST("user/auth")
    fun getAuthPage(
    ): retrofit2.Call<RequestResultVO>

    @GET("user/auth")
    fun requestPage(
        @Query("pageNum") pageNum : Int
    ): retrofit2.Call<RequestResultVO>
}