package com.example.composenewsapp.ui.api

import com.example.data.api.NewsServices
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiManager {
    companion object{
        private var instance : Retrofit ?= null
        private fun getInstance():Retrofit{
            if(instance == null){
                instance = Retrofit
                    .Builder()
                    .baseUrl("https://newsapi.org/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return instance!!
        }

        fun getApi():NewsServices{
           return getInstance().create(NewsServices::class.java)
        }
    }
}