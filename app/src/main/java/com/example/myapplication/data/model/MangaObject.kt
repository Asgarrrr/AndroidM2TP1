package com.example.myapplication.data.model

data class MangaObject(
    val url: String,
    val malId: Int,
    val title: String,
    val titleJapanese: String,
    val type: String,
    val chapters: Int,
    val volumes: Int,
    val status: String,
    val imageUrl: String,
)

data class MangaAuthor(
    val name: String
)

fun List<MangaEntity>.toUi(): List<MangaObject> {
    return map { eachEntity ->
        MangaObject(
            url = eachEntity.url,
            malId = eachEntity.malId,
            title = eachEntity.title,
            titleJapanese = eachEntity.titleJapanese,
            type = eachEntity.type,
            chapters = eachEntity.chapters,
            volumes = eachEntity.volumes,
            status = eachEntity.status,
            imageUrl = eachEntity.imageUrl,
        )
    }
}
