package com.example.api

import retrofit2.Call
import retrofit2.http.GET

interface MyService {
    @GET("quotes/lang/en")
    fun quotes(): Call<List<Quote>>
}