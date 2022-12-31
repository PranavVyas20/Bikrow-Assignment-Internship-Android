package com.example.brikowassignment

import androidx.compose.runtime.Composable
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.brikowassignment.screens.AddVehicleScreen
import com.example.brikowassignment.screens.BookingListScreen
import com.example.brikowassignment.screens.LoginScreen
import com.example.brikowassignment.screens.UserReceiptScreen

@Composable
fun BottomBarNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Login.route
    ) {
        composable(route = BottomBarScreen.Login.route) {
            LoginScreen()
        }
        composable(route = BottomBarScreen.Book.route) {
            BookingListScreen()
        }
        composable(route = BottomBarScreen.Search.route) {
            AddVehicleScreen()
        }
        composable(route = BottomBarScreen.Exit.route) {
            UserReceiptScreen()
        }
    }
}
