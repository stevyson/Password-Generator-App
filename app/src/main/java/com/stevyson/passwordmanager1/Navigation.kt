package com.stevyson.passwordmanager1

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.stevyson.passwordmanager1.presentation.generator.GeneratorScreen
import com.stevyson.passwordmanager1.presentation.homescreen.HomeScreen
import com.stevyson.passwordmanager1.presentation.password.add_screen.Add
import com.stevyson.passwordmanager1.presentation.password.PasswordScreen


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController = navController,startDestination =Screen.HomeScreen.route) {
        composable(route = Screen.HomeScreen.route){
            HomeScreen(navController = navController)
        }
        composable(route = Screen.PasswordScreen.route){
            PasswordScreen(navController = navController)
        }
        composable(route = Screen.GeneratorScreen.route){
            GeneratorScreen(navController = navController)
        }
        composable(route = Screen.AddScreen.route + "?passwordId={passwordId}",
            arguments = listOf(
                navArgument(
                    name = "passwordId"
                ) {
                    type = NavType.IntType
                    defaultValue = -1
                }
            )
        ){
            Add(navController = navController)
        }
    }
}




sealed class Screen(val route: String) {
    object HomeScreen: Screen("home_screen")
    object AddScreen: Screen("add_screen")
    object PasswordScreen: Screen("password_screen")
    object GeneratorScreen: Screen("generator_screen")
}



