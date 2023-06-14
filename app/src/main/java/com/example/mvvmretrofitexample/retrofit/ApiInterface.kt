package com.example.mvvmretrofitexample.retrofit


import com.example.mvvmretrofitexample.model.Movie
import com.example.mvvmretrofitexample.model.ServicesSetterGetter
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("movielist.json")
    fun getServices() : Call<ServicesSetterGetter>


    @GET("movielist.json")
    fun getMovies() : Call<List<Movie>>

}