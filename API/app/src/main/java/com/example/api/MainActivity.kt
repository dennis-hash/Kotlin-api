package com.example.api

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         getQuote()
    }
   private fun getQuote() {
        val retro = Retro().getRetroClient().create(BreakingBadApi::class.java)
        retro.getQuote().enqueue(object : Callback<List<BrakingBadModel>> {
          override fun onResponse(
                call: Call<List<BrakingBadModel>>,
                        response: Response<List<BrakingBadModel>>
            ){
                for(q in response.body()!!){
                   Log.e("WOW", q.quote.toString())
                }
            }
            override fun onFailure(call: Call<List<BrakingBadModel>>, t: Throwable){
                Log.e("Fail","Failed")
            }
        })
    }
}
