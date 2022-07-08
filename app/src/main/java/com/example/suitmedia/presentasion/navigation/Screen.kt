package com.example.suitmedia.presentasion.navigation

const val SCREEN_ROUTE = "screen_route"

sealed class Screen(val route : String){
    object screen1 : Screen("1_screen")
    object screen2 : Screen("2_screen?name={name}&username={username}"){
        fun passNameAndUsername(
            name : String ="Name",
            username : String = "Selected Username"
        ) : String {
            return "2_screen?name=$name&username=$username"
        }
    }
    object screen3 : Screen("3_screen")
}


