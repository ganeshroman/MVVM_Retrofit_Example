package com.example.mvvmretrofitexample.retrofit


import com.example.mvvmretrofitexample.model.ServicesSetterGetter
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("services")
    fun getServices() : Call<ServicesSetterGetter>

}