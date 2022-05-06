package com.example.tasks.service.repository

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class RetrofitClient {

    companion object {

        private lateinit var retrofit: Retrofit
        private val baseUrl = "http://devmasterteam.com/cursoandroidAPI/"
        private fun getRetrofitInstance() : Retrofit {

            val httpClient = OkHttpClient.Builder()
            if(:: retrofit.isInitialized) {
                retrofit = Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .client(httpClient.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit
        }

        fun <S>createService(serviceClass: Class<S>): S{
            return getRetrofitInstance().create(serviceClass)
        }
    }
}