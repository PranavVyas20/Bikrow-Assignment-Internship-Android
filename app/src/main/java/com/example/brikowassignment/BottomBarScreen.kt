package com.example.brikowassignment

sealed class BottomBarScreen(
    val route: String,
    val title: String,
) {
    object Login : BottomBarScreen(
        route = "login",
        title = "Login",
    )

    object Book : BottomBarScreen(
        route = "book",
        title = "Book",
    )

    object Search : BottomBarScreen(
        route = "search",
        title = "Search",
    )
    object Exit : BottomBarScreen(
        route = "exit",
        title = "Exit",
    )
}
