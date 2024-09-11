package com.example.myapplication.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.repository.BooksRepository
import com.example.myapplication.ui.model.ItemUi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlin.random.Random

class BookViewModel : ViewModel() {

    private val booksRepository: BooksRepository by lazy { BooksRepository() }

    private val _bookList: Flow<List<ItemUi>>
        get() = booksRepository.selectAllBooks().map { androidObjectEntities ->
            androidObjectEntities.groupBy { book ->
                book.genre
            } .flatMap {
                buildList {
                    add(ItemUi.Header(
                        title = it.key,
                    ))
                    addAll(it.value)
                }
            }
        }

    val bookList : Flow<List<ItemUi>> get() = _bookList

    fun insertBook() {
        viewModelScope.launch(Dispatchers.IO) {
            val random = Random.nextInt(0, 10)
            booksRepository.insertBook(
                ItemUi.Item(
                    id = random,
                    title = "Title $random",
                    author = "Author $random",
                    genre = "Genre $random",
                    imageUrl = "https://picsum.photos/200/300"
                )
            )
        }
    }


    fun deleteAllBooks() {
        viewModelScope.launch(Dispatchers.IO) {
            booksRepository.deleteAllBooks()
        }
    }
}


