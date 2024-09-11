package com.example.myapplication.data.model

data class Manga(
    val malId: Int,
    val url: String,
    val title: String,
    val titleJapanese: String,
    val type: String,
    val chapters: Int,
    val volumes: Int,
    val status: String,
    val imageUrl: String,
)