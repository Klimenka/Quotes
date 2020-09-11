package com.example.api

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_recyclerview.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MainActivity : AppCompatActivity(), Callback<List<Quote>> {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recyclerview)
        println("hello")
        val retrofit = Retrofit.Builder()
            .baseUrl("https://programming-quotes-api.herokuapp.com/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
        println("hello again")
        val service = retrofit.create(MyService::class.java)
        service.quotes().enqueue(this)
    }

    override fun onFailure(call: Call<List<Quote>>, t: Throwable) {
        Log.e("HTTP", "Could not fetch data", t)
    }

    override fun onResponse(call: Call<List<Quote>>, response: Response<List<Quote>>) {
        if (response.isSuccessful && response.body() != null) {
            println(response.body())
            val quotes= response.body() as List<Quote>
            this.recyclerview.layoutManager = LinearLayoutManager(this)
            this.recyclerview.adapter = MyAdapter(this, quotes)
        }
    }
}