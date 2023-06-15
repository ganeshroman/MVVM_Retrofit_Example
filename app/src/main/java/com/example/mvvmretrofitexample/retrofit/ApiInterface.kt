package com.example.mvvmretrofitexample.retrofit


import com.example.mvvmretrofitexample.model.Movie
import com.example.mvvmretrofitexample.model.ServicesSetterGetter
import com.example.mvvmretrofitexample.model.Weather
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("movielist.json")
    fun getServices() : Call<ServicesSetterGetter>


    @GET("movielist.json")
    fun getMovies() : Call<List<Movie>>

    @GET("weather")
    fun getWeather(@Query("lat") lat: String?,@Query("lon") lon: String?,@Query("appid") appid: String?) : Call<Weather>


    // @GET("myObjects/{id}")
    //    fun myObjectById(@Path("id") id: Int?, @Query("a_param") aParam: String?)




    // @GET("/coordsOfTrip{id}")
    //fun getTripCoord(
    //        @Header("Authorization") token: String,
    //        @Path("id") id: Int    // use @Path() instead of @Query()
    //)
}