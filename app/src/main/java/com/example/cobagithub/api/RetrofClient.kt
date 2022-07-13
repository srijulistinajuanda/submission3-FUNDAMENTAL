package com.example.cobagithub.api

import android.app.Service
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofClient{
    fun getService(): Api {
        val loggingInterceptor =
            HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder().addInterceptor(loggingInterceptor).build()
        val retrofit = Retrofit.Builder().baseUrl("https://api.github.com/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create()).build()
        return retrofit.create(Api::class.java)
    }
}