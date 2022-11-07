package com.example.api

import retrofit2.Call
import retrofit2.http.GET

interface BreakingBadApi {
    @GET("quotes")
    fun getQuote(): Call<List<BrakingBadModel>>
}