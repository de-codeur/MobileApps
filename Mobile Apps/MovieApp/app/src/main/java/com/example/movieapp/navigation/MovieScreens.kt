package com.example.movieapp.navigation

enum class MovieScreens{
    HomeScreen,
    DetailScreens;
    companion object{
        fun fromRoute(route:String?):MovieScreens=
            when(route?.substringAfter("/")){
                HomeScreen.name->HomeScreen
                DetailScreens.name->DetailScreens

                else -> throw IllegalArgumentException("Route")
            }

    }
}
