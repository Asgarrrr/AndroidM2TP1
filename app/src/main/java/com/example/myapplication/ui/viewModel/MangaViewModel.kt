package com.example.myapplication.ui.viewModel

import androidx.lifecycle.ViewModel
import com.example.myapplication.data.repository.MangaRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.model.Manga
import com.example.myapplication.data.model.MangaObject
import com.example.myapplication.data.model.toUi
import com.example.myapplication.ui.model.MangaUi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class MangaViewModel : ViewModel() {
    private val mangaRepository: MangaRepository by lazy { MangaRepository() }
    private val _manga: Flow<List<MangaObject>>
        get() = mangaRepository.selectAll()
    val manga = _manga
    fun insertNewManga() {
        viewModelScope.launch(Dispatchers.IO) {
            mangaRepository.fetchData()
        }
    }
    fun deleteAllManga() {
        viewModelScope.launch(Dispatchers.IO) {
            mangaRepository.deleteAll()
        }
    }
}

