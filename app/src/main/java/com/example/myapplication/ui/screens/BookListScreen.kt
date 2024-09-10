package com.example.myapplication.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.myapplication.ui.model.Book

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookListScreen(books: List<Book>) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Book List") }
            )
        }
    ) { paddingValues ->
        val groupedBooks = books.groupBy { it.genre }

        LazyColumn(
            modifier = Modifier.padding(paddingValues)
        ) {
            groupedBooks.forEach { (genre, booksInGenre) ->
                item {
                    Text(
                        text = genre,
                        style = MaterialTheme.typography.titleLarge,
                        modifier = Modifier.padding(16.dp)
                    )
                }
                items(booksInGenre) { book ->
                    BookItem(book)
                }
            }
        }
    }
}

@Composable
fun BookItem(book: Book) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
    ) {
        Row(modifier = Modifier.padding(16.dp)) {
            val painter = rememberAsyncImagePainter(
                ImageRequest.Builder(LocalContext.current)
                    .data(book.imageUrl)
                    .build()
            )
            Image(
                painter = painter,
                contentDescription = null,
                modifier = Modifier.size(64.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(text = book.title, style = MaterialTheme.typography.titleMedium)
                Text(text = book.author, style = MaterialTheme.typography.bodySmall)
            }
        }
    }
}

@Preview
@Composable
fun PreviewBookItem() {
    BookItem(
        Book(
            id = 1,
            title = "1984",
            author = "George Orwell",
            genre = "Dystopian",
            imageUrl = "https://cdn.kobo.com/book-images/c9472126-7f96-402d-ba57-5ba4c0f4b238/1200/1200/False/nineteen-eighty-four-1984-george.jpg"
        )
    )
}