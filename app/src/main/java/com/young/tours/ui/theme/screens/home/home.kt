package com.young.tours.ui.theme.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.young.tours.R
import com.young.tours.navigation.ROUTE_ITINERARY
import com.young.tours.navigation.ROUTE_PREPARATION
import com.young.tours.navigation.ROUTE_TRAVELPREFFRENCE

@Composable
fun  HomeScreen(navController: NavHostController){
  Image(painter = painterResource(id = R.drawable.jelly),
      contentDescription =null,
      contentScale = ContentScale.FillBounds,
      modifier = Modifier.fillMaxSize()
      )
    Column {
        Text(text = "ToursRUs",
            color = Color.White,
            fontFamily = FontFamily.Cursive,
            fontSize = 20.sp
        )

        Button(onClick = {  navController.navigate(ROUTE_ITINERARY) }) {
            Text(" Itinerary")
        }
        Spacer(modifier = Modifier.height(6.dp))
        Button(onClick = {  navController.navigate(ROUTE_TRAVELPREFFRENCE) }) {
            Text(" TravelPreference")
        }
        Spacer(modifier = Modifier.height(6.dp))
        Button(onClick = {  navController.navigate(ROUTE_PREPARATION) }) {
            Text(" Preparation")
        }

    }

    }



@Preview
@Composable
fun HomePrev(){
    HomeScreen(navController = rememberNavController())
}