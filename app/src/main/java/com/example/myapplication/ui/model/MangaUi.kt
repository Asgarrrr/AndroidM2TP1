package com.example.myapplication.ui.model

import com.example.myapplication.data.model.Manga

sealed interface MangaUi {

    data class Item(
        val malId: Int,
        val title: String,
        val titleJapanese: String,
        val type: String,
        val chapters: Int,
        val volumes: Int,
        val status: String,
        val imageUrl: String,
    ) : MangaUi

    data class Header(val title: String) : MangaUi
    data class Footer(val title: String) : MangaUi

}

fun List<Manga>.toUi(): List<MangaUi.Item> {
    return map { currentMangaEntity ->
        MangaUi.Item(
            malId = currentMangaEntity.malId,
            title = currentMangaEntity.title,
            titleJapanese = currentMangaEntity.titleJapanese,
            type = currentMangaEntity.type,
            chapters = currentMangaEntity.chapters,
            volumes = currentMangaEntity.volumes,
            status = currentMangaEntity.status,
            imageUrl = currentMangaEntity.imageUrl,
        )
    }
}
