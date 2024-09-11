package com.example.myapplication.data.remote

import com.example.myapplication.data.model.DataMangaDto
import retrofit2.http.GET

interface MangaEndpoint {

    @GET("random/manga")
    suspend fun getRandomManga() : DataMangaDto

}
