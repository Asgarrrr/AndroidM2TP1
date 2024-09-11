package com.example.myapplication.ui.model

import com.example.myapplication.data.model.Book

sealed interface ItemUi {

    data class Item(
        val id: Int,
        val title: String,
        val author: String,
        val genre: String,
        val imageUrl: String
    ) : ItemUi

    data class Header(val title: String) : ItemUi
    data class Footer(val title: String) : ItemUi

}

fun List<Book>.toUi(): List<ItemUi.Item> {
    return map { currentAndroidObject ->
        ItemUi.Item(
            id = currentAndroidObject.id,
            title = currentAndroidObject.title,
            author = currentAndroidObject.author,
            genre = currentAndroidObject.genre,
            imageUrl = currentAndroidObject.imageUrl
        )
    }
}


