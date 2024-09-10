package com.example.myapplication.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.screens.MainScreen
import com.example.myapplication.ui.screens.BookListScreen
import com.example.myapplication.ui.model.Book

object NavigationPath {
    const val MAIN_SCREEN = "main_screen"
    const val LIST_SCREEN = "list_screen"
}

fun NavGraphBuilder.addMainScreenNav(
    onButtonClick: () -> Unit,
) {
    composable(
        route = NavigationPath.MAIN_SCREEN
    ) {
        MainScreen(
            onButtonClick = onButtonClick
        )
    }
}

fun NavGraphBuilder.addListScreenNavigation() {
    composable(
        route = NavigationPath.LIST_SCREEN,
    ) {
        val books = listOf(
            Book(1, "1984", "George Orwell", "Dystopian", "https://cdn.kobo.com/book-images/c9472126-7f96-402d-ba57-5ba4c0f4b238/1200/1200/False/nineteen-eighty-four-1984-george.jpg"),
            Book(2, "To Kill a Mockingbird", "Harper Lee", "Classic", "https://m.media-amazon.com/images/I/81aY1lxk+9L._AC_UF1000,1000_QL80_.jpg"),
            Book(3, "The Great Gatsby", "F. Scott Fitzgerald", "Classic", "https://upload.wikimedia.org/wikipedia/commons/7/7a/The_Great_Gatsby_Cover_1925_Retouched.jpg"),
            Book(4, "Brave New World", "Aldous Huxley", "Dystopian", "https://m.media-amazon.com/images/I/91D4YvdC0dL._AC_UF1000,1000_QL80_.jpg"),
            Book(5, "The Catcher in the Rye", "J.D. Salinger", "Classic", "https://m.media-amazon.com/images/I/81aY1lxk+9L._AC_UF1000,1000_QL80_.jpg"),
            Book(6, "Animal Farm", "George Orwell", "Dystopian", "https://cdn.kobo.com/book-images/c9472126-7f96-402d-ba57-5ba4c0f4b238/1200/1200/False/nineteen-eighty-four-1984-george.jpg"),
            Book(7, "The Bell Jar", "Sylvia Plath", "Classic", "https://m.media-amazon.com/images/I/81aY1lxk+9L._AC_UF1000,1000_QL80_.jpg"),
            Book(8, "The Road", "Cormac McCarthy", "Dystopian", "https://cdn.kobo.com/book-images/c9472126-7f96-402d-ba57-5ba4c0f4b238/1200/1200/False/nineteen-eighty-four-1984-george.jpg"),
            Book(9, "The Hobbit", "J.R.R. Tolkien", "Fantasy", "https://m.media-amazon.com/images/I/81aY1lxk+9L._AC_UF1000,1000_QL80_.jpg"),
            Book(10, "Harry Potter and the Sorcerer's Stone", "J.K. Rowling", "Fantasy", "https://cdn.kobo.com/book-images/c9472126-7f96-402d-ba57-5ba4c0f4b238/1200/1200/False/nineteen-eighty-four-1984-george.jpg"),
            Book(11, "The Lion, the Witch, and the Wardrobe", "C.S. Lewis", "Fantasy", "https://m.media-amazon.com/images/I/81aY1lxk+9L._AC_UF1000,1000_QL80_.jpg"),
            Book(12, "The Fellowship of the Ring", "J.R.R. Tolkien", "Fantasy", "https://cdn.kobo.com/book-images/c9472126-7f96-402d-ba57-5ba4c0f4b238/1200/1200/False/nineteen-eighty-four-1984-george.jpg"),
            Book(13, "The Two Towers", "J.R.R. Tolkien", "Fantasy", "https://m.media-amazon.com/images/I/81aY1lxk+9L._AC_UF1000,1000_QL80_.jpg"),
            Book(14, "The Return of the King", "J.R.R. Tolkien", "Fantasy", "https://cdn.kobo.com/book-images/c9472126-7f96-402d-ba57-5ba4c0f4b238/1200/1200/False/nineteen-eighty-four-1984-george.jpg"),
            Book(15, "Dune", "Frank Herbert", "Science Fiction", "https://m.media-amazon.com/images/I/81aY1lxk+9L._AC_UF1000,1000_QL80_.jpg"),
            Book(16, "Foundation", "Isaac Asimov", "Science Fiction", "https://cdn.kobo.com/book-images/c9472126-7f96-402d-ba57-5ba4c0f4b238/1200/1200/False/nineteen-eighty-four-1984-george.jpg"),
            Book(17, "Neuromancer", "William Gibson", "Science Fiction", "https://m.media-amazon.com/images/I/81aY1lxk+9L._AC_UF1000,1000_QL80_.jpg"),
            Book(18, "Snow Crash", "Neal Stephenson", "Science Fiction", "https://cdn.kobo.com/book-images/c9472126-7f96-402d-ba57-5ba4c0f4b238/1200/1200/False/nineteen-eighty-four-1984-george.jpg"),
        )
        BookListScreen(books)
    }
}

@Composable
fun HomeNavHost(
    navController: NavHostController = rememberNavController(),
) {
    NavHost(
        navController = navController,
        startDestination = NavigationPath.MAIN_SCREEN,
    ) {
        addMainScreenNav(
            onButtonClick = {
                navController.navigate(NavigationPath.LIST_SCREEN)
            }
        )
        addListScreenNavigation()
    }
}