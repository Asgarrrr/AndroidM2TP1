package com.example.myapplication.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.myapplication.ui.model.ItemUi

@Entity(tableName = "book")
data class BookEntity(

    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo(name = "author")
    val author: String,

    @ColumnInfo(name = "genre")
    val genre: String,

    @ColumnInfo(name = "image_url")
    val imageUrl: String,

) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}

fun ItemUi.Item.toRoomObject(): BookEntity {
    return BookEntity(
        title = title,
        author = author,
        genre = genre,
        imageUrl = imageUrl
    )
}


fun List<BookEntity>.toUi(): List<ItemUi.Item> {
    return map { eachItem ->
        ItemUi.Item(
            id = eachItem.id.toInt(),
            title = eachItem.title,
            author = eachItem.author,
            genre = eachItem.genre,
            imageUrl = eachItem.imageUrl
        )
    }
}
