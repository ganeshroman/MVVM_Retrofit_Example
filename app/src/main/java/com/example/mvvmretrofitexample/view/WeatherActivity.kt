package com.example.mvvmretrofitexample.view

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmretrofitexample.databinding.ActivityMainBinding
import com.example.mvvmretrofitexample.viewmodel.WeatherViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WeatherActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    lateinit var context: Context

    lateinit var mainActivityViewModel: WeatherViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        context = this@WeatherActivity

        mainActivityViewModel = ViewModelProvider(this).get(WeatherViewModel::class.java)

        binding.btnClick.setOnClickListener {

            binding.wp7progressBar.visibility= View.VISIBLE

            var lat:String ="10.99"
            var lon:String = "44.34"

            mainActivityViewModel.getWeather(lat,lon)!!.observe(this, Observer { serviceSetterGetter ->

                binding.wp7progressBar.visibility=View.INVISIBLE

                val msg = serviceSetterGetter.toString()

                binding.lblResponse.text = msg

            })

        }

    }
}