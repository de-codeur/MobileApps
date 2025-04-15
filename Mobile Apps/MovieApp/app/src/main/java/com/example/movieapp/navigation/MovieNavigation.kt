package com.example.movieapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.movieapp.screens.Details.DetailScreen
import com.example.movieapp.screens.HomeSc.HomeScreen

@Composable
fun MovieNavigation(){
    val navController= rememberNavController()
    NavHost(navController=navController, startDestination = MovieScreens.HomeScreen.name){
        composable(MovieScreens.HomeScreen.name){
            // here is where we pass where we want to lead us to
            HomeScreen(navController = navController)
        }
        composable(route = "DetailScreen"){
            DetailScreen(navController=navController)
        }
    }
}