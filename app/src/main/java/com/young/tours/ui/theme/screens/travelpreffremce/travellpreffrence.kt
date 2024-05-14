package com.young.tours.ui.theme.screens.travelpreffremce

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.young.tours.R


val destinations = listOf("New York", "Paris", "Tokyo", "Sydney", "Nairobi", "Mombasa", "Kisumu")


val luxuryLevels = listOf("Budget", "Standard", "Luxury")


class TravelPreferenceViewModel : ViewModel() {
    var selectedDestination by mutableStateOf(destinations.first())
    var selectedLuxuryLevel by mutableStateOf(luxuryLevels.first())
    var isDomestic by mutableStateOf(true)

    fun setDestination(destination: String) {
        selectedDestination = destination
    }

    fun setLuxuryLevel(level: String) {
        selectedLuxuryLevel = level
    }

    fun toggleDomestic() {
        isDomestic = !isDomestic
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TravelPreferenceScreen(navController: NavHostController) {
    Image(painter = painterResource(id = R.drawable.jelly),
        contentDescription =null,
        contentScale = ContentScale.FillBounds,
        modifier = Modifier.fillMaxSize()
    )

    val viewModel: TravelPreferenceViewModel = viewModel()

    var expanded by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Destination dropdown
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = { expanded = !expanded }
        ) {
            TextField(
                value = viewModel.selectedDestination,
                onValueChange = {},
                readOnly = true,
                label = { Text("Select Destination") },
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
                },
                modifier = Modifier.fillMaxWidth()
            )
            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                destinations.forEach { destination ->
                    DropdownMenuItem(
                        text = { Text(destination) },
                        onClick = {
                            viewModel.setDestination(destination)
                            expanded = false
                        }
                    )
                }
            }
        }


        Column {
            Text("Level of Luxury")
            luxuryLevels.forEach { level ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(4.dp)
                ) {
                    RadioButton(
                        selected = viewModel.selectedLuxuryLevel == level,
                        onClick = { viewModel.setLuxuryLevel(level) }
                    )
                    Text(level)
                }
            }
        }


        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(4.dp)
        ) {
            Text(if (viewModel.isDomestic) "Domestic" else "International")
            Switch(
                checked = viewModel.isDomestic,
                onCheckedChange = { viewModel.toggleDomestic() }
            )
        }


        Button(
            onClick = {

                println("Submitted preferences: Destination - ${viewModel.selectedDestination}, Luxury - ${viewModel.selectedLuxuryLevel}, ${if (viewModel.isDomestic) "Domestic" else "International"}")
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Submit")
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun TravelPreferencePagePreview() {
    TravelPreferenceScreen(navController= rememberNavController())
}
