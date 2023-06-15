package com.example.mvvmretrofitexample.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmretrofitexample.model.Weather
import com.example.mvvmretrofitexample.repository.WeatherRepository
import retrofit2.http.Query


class WeatherViewModel : ViewModel() {

    var servicesLiveData: MutableLiveData<Weather>? = null

    fun getWeather(lat: String?, lon: String?) : LiveData<Weather>? {
        servicesLiveData = WeatherRepository.getWeatherApiCall(lat,lon)
        return servicesLiveData
    }

}