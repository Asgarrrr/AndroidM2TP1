package com.example.myapplication.data.repository

import com.example.myapplication.architecture.CustomApplication
import com.example.myapplication.data.model.toRoomObject
import com.example.myapplication.data.model.toUi
import com.example.myapplication.ui.model.ItemUi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class BooksRepository {
    
    private val bookDao = CustomApplication.instance.mApplicationDatabase.androidVersionDao()
    
    fun selectAllBooks(): Flow<List<ItemUi.Item>> {
        return bookDao.selectAll().map {
            it.toUi()
        }
    }

    fun insertBook(androidObject: ItemUi.Item) {
        bookDao.insert(androidObject.toRoomObject())
    }

    fun deleteAllBooks() {
        bookDao.deleteAll()
    }
}
