package com.example.myapplication.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DataMangaDto(
    @Expose
    @SerializedName("data")
    val data: MangaDto
)

data class MangaDto(
    @Expose
    @SerializedName("mal_id")
    val malId: Int,

    @Expose
    @SerializedName("url")
    val url: String,

    @Expose
    @SerializedName("title")
    val title: String,

    @Expose
    @SerializedName("title_japanese")
    val titleJapanese: String,

    @Expose
    @SerializedName("type")
    val type: String,

    @Expose
    @SerializedName("chapters")
    val chapters: Int,

    @Expose
    @SerializedName("volumes")
    val volumes: Int,

    @Expose
    @SerializedName("status")
    val status: String,

    @Expose
    @SerializedName("published")
    val published: Published,

    @Expose
    @SerializedName("images")
    val images: Images,

    @Expose
    @SerializedName("authors")
    val authors: List<Author>,

    @Expose
    @SerializedName("genres")
    val genres: List<Genre>
)

data class Published(
    @Expose
    @SerializedName("from")
    val from: String,

    @Expose
    @SerializedName("to")
    val to: String
)

data class Images(
    @Expose
    @SerializedName("jpg")
    val jpg: ImageUrls
)

data class ImageUrls(
    @Expose
    @SerializedName("image_url")
    val imageUrl: String
)

data class Author(
    @Expose
    @SerializedName("name")
    val name: String
)

data class Genre(
    @Expose
    @SerializedName("name")
    val name: String
)

fun DataMangaDto.toRoom(): MangaEntity {
    return MangaEntity(
        malId = data.malId,
        url = data.url,
        title = data.title,
        titleJapanese = data.titleJapanese,
        type = data.type,
        chapters = data.chapters,
        volumes = data.volumes,
        status = data.status,
        imageUrl = data.images.jpg.imageUrl,
    )
}
