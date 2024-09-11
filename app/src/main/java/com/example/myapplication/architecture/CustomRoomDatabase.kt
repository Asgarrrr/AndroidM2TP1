package com.example.myapplication.architecture

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myapplication.data.dao.BookDao
import com.example.myapplication.data.dao.MangaDao
import com.example.myapplication.data.model.BookEntity
import com.example.myapplication.data.model.MangaEntity

@Database(
    entities = [
        BookEntity::class,
        MangaEntity::class
    ],
    version = 7,
    exportSchema = false
)
abstract class CustomRoomDatabase : RoomDatabase() {
    abstract fun androidVersionDao(): BookDao
    abstract fun mangaDao(): MangaDao
}