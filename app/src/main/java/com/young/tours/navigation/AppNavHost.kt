package com.young.tours.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.young.tours.ui.theme.screens.home.HomeScreen
import com.young.tours.ui.theme.screens.itinerary.ItineraryScreen
import com.young.tours.ui.theme.screens.login.LoginScreen
import com.young.tours.ui.theme.screens.passport.PassportScreen
import com.young.tours.ui.theme.screens.prepanddepart.PreparationScreen
import com.young.tours.ui.theme.screens.signup.SignUpScreen
import com.young.tours.ui.theme.screens.splash.SplashScreen
import com.young.tours.ui.theme.screens.travelpreffremce.TravelPreferenceScreen


@Composable
fun  AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String= ROUTE_SPLASH
){
    NavHost(navController = navController, modifier = modifier,
        startDestination =startDestination ) {
        composable(ROUTE_LOGIN){
            LoginScreen(navController)
        }
        composable(ROUTE_SIGNUP){
            SignUpScreen(navController)
        }
        composable(ROUTE_SPLASH){
            SplashScreen(navController)
        }
        composable(ROUTE_LOGIN){
            LoginScreen(navController)
        }
        composable(ROUTE_SIGNUP){
            SignUpScreen(navController )
        }
        composable(ROUTE_HOME){
            HomeScreen(navController)
        }
        composable(ROUTE_ITINERARY){
            ItineraryScreen(navController)
        }
        composable(ROUTE_TRAVELPREFFRENCE){
            TravelPreferenceScreen(navController)
        }
        composable(ROUTE_PREPARATION){
            PreparationScreen(navController )
        }
        composable(ROUTE_PASSPORT){
            PassportScreen(navController)
        }

    }
}