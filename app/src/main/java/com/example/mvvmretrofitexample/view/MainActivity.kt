package com.example.mvvmretrofitexample.view


import android.content.Context
//import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
//import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmretrofitexample.R
import com.example.mvvmretrofitexample.databinding.ActivityMainBinding
import com.example.mvvmretrofitexample.model.ServicesSetterGetter
import com.example.mvvmretrofitexample.repository.MainActivityRepository
import com.example.mvvmretrofitexample.retrofit.RetrofitClient
import com.example.mvvmretrofitexample.viewmodel.MainActivityViewModel
//import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    lateinit var context: Context

    lateinit var mainActivityViewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        context = this@MainActivity

        mainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        binding.btnClick.setOnClickListener {

            binding.wp7progressBar.visibility= View.VISIBLE

            mainActivityViewModel.getUser()!!.observe(this, Observer { serviceSetterGetter ->

                binding.wp7progressBar.visibility=View.INVISIBLE

                val msg = serviceSetterGetter.message

                binding.lblResponse.text = msg

            })

        }

    }
}