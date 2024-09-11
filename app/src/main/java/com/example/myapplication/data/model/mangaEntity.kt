package com.example.myapplication.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "manga")
data class MangaEntity(
    @ColumnInfo(name = "mal_id")
    val malId: Int,

    @ColumnInfo(name = "url")
    val url: String,

    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo(name = "title_japanese")
    val titleJapanese: String,

    @ColumnInfo(name = "type")
    val type: String,

    @ColumnInfo(name = "chapters")
    val chapters: Int,

    @ColumnInfo(name = "volumes")
    val volumes: Int,

    @ColumnInfo(name = "status")
    val status: String,

    @ColumnInfo(name = "image_url")
    val imageUrl: String,

) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}
