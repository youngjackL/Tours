package com.young.tours.ui.theme.screens.prepanddepart

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.young.tours.R

@Composable
fun PreparationScreen(navController: NavHostController) {
    Image(painter = painterResource(id = R.drawable.jelly),
        contentDescription =null,
        contentScale = ContentScale.FillBounds,
        modifier = Modifier.fillMaxSize()
    )

    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Text(text = "Preparation Details", style = TextStyle(color = Color.Black, fontSize = 20.sp, fontWeight = FontWeight.Bold))
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = "Pack essentials like clothes, toiletries, and travel documents.")
        Spacer(modifier = Modifier.height(4.dp))

        Text(text = "Departure Details", style = TextStyle(color = Color.Black, fontSize = 20.sp, fontWeight = FontWeight.Bold))
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = "Departure City: New York")
        Text(text = "Destination City: Los Angeles")
        Text(text = "Departure Time: 10:00 AM")
        Text(text = "Arrival Time: 1:00 PM")
        Text(text = "Flight Number: ABC123")
    }

}

@Preview
@Composable
fun Prepprev(){
    PreparationScreen(navController = rememberNavController())
}