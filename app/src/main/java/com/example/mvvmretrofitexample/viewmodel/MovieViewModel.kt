package com.example.mvvmretrofitexample.viewmodel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmretrofitexample.model.Movie
import com.example.mvvmretrofitexample.model.ServicesSetterGetter
import com.example.mvvmretrofitexample.repository.MainActivityRepository
import com.example.mvvmretrofitexample.repository.MoviesRepository

class MovieViewModel : ViewModel() {

    var servicesLiveData: MutableLiveData<List<Movie>>? = null

    fun getMovies() : LiveData<List<Movie>>? {
        servicesLiveData = MoviesRepository.getMoviesApiCall()
        return servicesLiveData
    }

}