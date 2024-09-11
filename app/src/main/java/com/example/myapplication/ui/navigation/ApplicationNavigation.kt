package com.example.myapplication.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.screens.MainScreen
import com.example.myapplication.ui.screens.BookListScreen
import com.example.myapplication.ui.screens.MangaScreen

object NavigationPath {
    const val MAIN_SCREEN = "main_screen"
    const val LIST_SCREEN = "list_screen"
    const val MANGA_SCREEN = "manga_screen"
}

fun NavGraphBuilder.addMainScreenNav(
    onButtonClick: () -> Unit,
    onButton2Click: () -> Unit
) {
    composable(
        route = NavigationPath.MAIN_SCREEN
    ) {
        MainScreen(
            onButtonClick = onButtonClick,
            onButton2Click = onButton2Click
        )
    }
}

fun NavGraphBuilder.addListScreenNavigation(navController: NavController){
    composable(
        route = NavigationPath.LIST_SCREEN,
    ) {
        BookListScreen(navController = navController)
    }
}

fun NavGraphBuilder.addMangaScreenNavigation(navController: NavController){
    composable(
        route = NavigationPath.MANGA_SCREEN,
    ) {
        MangaScreen()
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
            },
            onButton2Click = {
                navController.navigate(NavigationPath.MANGA_SCREEN)
            }
        )
        addListScreenNavigation(navController = navController)
        addMangaScreenNavigation(navController = navController)
    }
}