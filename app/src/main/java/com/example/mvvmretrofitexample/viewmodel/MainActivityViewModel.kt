package com.example.mvvmretrofitexample.viewmodel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmretrofitexample.model.ServicesSetterGetter
import com.example.mvvmretrofitexample.repository.MainActivityRepository

class MainActivityViewModel : ViewModel() {

    var servicesLiveData: MutableLiveData<ServicesSetterGetter>? = null

    fun getUser() : LiveData<ServicesSetterGetter>? {
        servicesLiveData = MainActivityRepository.getServicesApiCall()
        return servicesLiveData
    }

}