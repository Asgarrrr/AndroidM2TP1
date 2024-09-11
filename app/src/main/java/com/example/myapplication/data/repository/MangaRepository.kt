package com.example.myapplication.data.repository

import com.example.myapplication.architecture.CustomApplication
import com.example.myapplication.architecture.RetrofitBuilder
import com.example.myapplication.data.model.MangaObject
import com.example.myapplication.data.model.toRoom
import com.example.myapplication.data.model.toUi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class MangaRepository {


    private val chuckNorrisDao = CustomApplication.instance.mApplicationDatabase.mangaDao()

    suspend fun fetchData() {
        chuckNorrisDao.insert(RetrofitBuilder.getRandomManga().getRandomManga().toRoom())
    }


    fun deleteAll() {
        chuckNorrisDao.deleteAll()
    }


    fun selectAll(): Flow<List<MangaObject>> {
        return chuckNorrisDao.selectAll().map { list ->
            list.toUi()
        }
    }
}
