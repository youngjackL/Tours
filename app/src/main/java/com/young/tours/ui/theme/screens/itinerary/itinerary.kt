package com.young.tours.ui.theme.screens.itinerary

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.young.tours.R
import com.young.tours.navigation.ROUTE_HOME
import com.young.tours.ui.theme.components.Header


@Composable
fun ItineraryScreen(navController: NavHostController) {
    Image(painter = painterResource(id = R.drawable.jelly),
        contentDescription =null,
        contentScale = ContentScale.FillBounds,
        modifier = Modifier.fillMaxSize()
    )

    var airline by rememberSaveable { mutableStateOf("") }
    var visadetails by rememberSaveable { mutableStateOf("") }
    var gateTerminal by rememberSaveable { mutableStateOf("") }
    var ticketDetails by rememberSaveable { mutableStateOf("") }
    var departure by rememberSaveable { mutableStateOf("") }
    var arrivalTime by rememberSaveable { mutableStateOf("") }
    var  hotelCheckin by rememberSaveable { mutableStateOf("") }


    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Header(text = "Input Your Itinerary Details",
            modifier = Modifier
                .padding(vertical = 5.dp)
                .align(alignment = Alignment.Start)

        )

        TextField(
            value = airline,
            onValueChange = { airline = it },
            label = { Text("Airline/Train/Taxi") }
        )
        TextField(
            value = visadetails,
            onValueChange = { visadetails = it },
            label = { Text("VisaDetails") }
        )
        TextField(
            value = gateTerminal,
            onValueChange = { gateTerminal = it },
            label = { Text("Gate Terminal") }
        )
        TextField(
            value = ticketDetails,
            onValueChange = {  ticketDetails = it },
            label = { Text("Ticket Details") }
        )
        TextField(
            value =departure ,
            onValueChange = { departure = it },
            label = { Text("Departure ") }
        )
        TextField(
            value =arrivalTime ,
            onValueChange = {  arrivalTime = it },
            label = { Text("Arrival ") }
        )
        TextField(
            value =hotelCheckin ,
            onValueChange = { hotelCheckin = it },
            label = { Text("Hotel Checkin") }
        )
        Button(onClick = {

navController.navigate(ROUTE_HOME)

        }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Submit")

        }

    }
}

@Preview
@Composable
fun ItenPrev(){
    ItineraryScreen(navController = rememberNavController())
}

