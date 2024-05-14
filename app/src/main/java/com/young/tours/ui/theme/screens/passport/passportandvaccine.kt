package com.young.tours.ui.theme.screens.passport

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
fun PassportScreen(navController: NavHostController){
    Image(painter = painterResource(id = R.drawable.jelly),
        contentDescription =null,
        contentScale = ContentScale.FillBounds,
        modifier = Modifier.fillMaxSize()
    )

    var passport by rememberSaveable { mutableStateOf("") }
    var vaccine by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Header(text = "Please Submit Your passport & Vaccination Details",
            modifier = Modifier
                .padding(vertical = 5.dp)
                .align(alignment = Alignment.Start)

        )

        TextField(
            value = passport,
            onValueChange = { passport = it },
            label = { Text("PassportDetails") }
        )
        TextField(
            value = vaccine,
            onValueChange = { vaccine = it },
            label = { Text("VaccineDetails") }
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
fun Passprev(){
    PassportScreen(navController = rememberNavController())
}
