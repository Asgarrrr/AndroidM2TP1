package com.example.myapplication.architecture

import com.example.myapplication.data.remote.MangaEndpoint
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://api.jikan.moe/v4/")
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
        .build()

    fun getRandomManga(): MangaEndpoint = retrofit.create(MangaEndpoint::class.java)

}