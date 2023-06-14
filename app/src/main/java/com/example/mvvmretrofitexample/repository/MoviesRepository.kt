package com.example.mvvmretrofitexample.repository

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvmretrofitexample.model.Movie
import com.example.mvvmretrofitexample.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object MoviesRepository {

    val moviesSetterGetter = MutableLiveData<List<Movie>>()

    fun getMoviesApiCall(): MutableLiveData<List<Movie>> {

        val call = RetrofitClient.apiInterface.getMovies()

        call.enqueue(object: Callback<List<Movie>> {
            override fun onFailure(call: Call<List<Movie>>, t: Throwable) {
                // TODO("Not yet implemented")
                Log.v("DEBUG : ", t.message.toString())
            }

            override fun onResponse(
                call: Call<List<Movie>>,
                response: Response<List<Movie>>
            ) {
                // TODO("Not yet implemented")
                Log.v("DEBUG : ", response.body().toString())

                val data = response.body()

                moviesSetterGetter.value=response.body()

                //val msg = data!!.message
                //serviceSetterGetter.value = Movie(msg)
            }
        })

        return moviesSetterGetter
    }
}


