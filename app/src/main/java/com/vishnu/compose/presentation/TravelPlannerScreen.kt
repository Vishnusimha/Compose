package com.vishnu.compose.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Explore
import androidx.compose.material.icons.filled.Flight
import androidx.compose.material.icons.filled.Hotel
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Savings
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TravelPlannerScreen() {
    var railIndex by remember { mutableIntStateOf(0) }
    var budgetRange by remember { mutableStateOf(20f..80f) }
    var dateFlexibility by remember { mutableStateOf(ToggleableState.Indeterminate) }
    var showDateDialog by remember { mutableStateOf(false) }

    Scaffold(
        floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = { },
                text = { Text("Plan Trip") },
                icon = { Icon(Icons.Default.Explore, contentDescription = null) }
            )
        }
    ) { paddingValues ->
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            NavigationRail {
                NavigationRailItem(
                    selected = railIndex == 0,
                    onClick = { railIndex = 0 },
                    icon = { Icon(Icons.Default.Flight, contentDescription = "Flights") },
                    label = { Text("Flights") }
                )
                NavigationRailItem(
                    selected = railIndex == 1,
                    onClick = { railIndex = 1 },
                    icon = { Icon(Icons.Default.Hotel, contentDescription = "Hotels") },
                    label = { Text("Hotels") }
                )
                NavigationRailItem(
                    selected = railIndex == 2,
                    onClick = { railIndex = 2 },
                    icon = { Icon(Icons.Default.Place, contentDescription = "Places") },
                    label = { Text("Places") }
                )
            }

            VerticalDivider()

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(14.dp)
            ) {
                Text(
                    text = "Trip Budget",
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold
                )

                Surface(
                    tonalElevation = 2.dp,
                    shape = MaterialTheme.shapes.medium,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(Icons.Default.Savings, contentDescription = null)
                            Spacer(modifier = Modifier.width(8.dp))
                            Text("Budget range")
                        }
                        Spacer(modifier = Modifier.height(12.dp))
                        RangeSlider(
                            value = budgetRange,
                            onValueChange = { budgetRange = it },
                            valueRange = 0f..100f
                        )
                        Text(
                            text = "Selected: $${(budgetRange.start * 100).toInt()} - $${(budgetRange.endInclusive * 100).toInt()}",
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                }

                Surface(
                    tonalElevation = 2.dp,
                    shape = MaterialTheme.shapes.medium,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        TriStateCheckbox(
                            state = dateFlexibility,
                            onClick = {
                                dateFlexibility = when (dateFlexibility) {
                                    ToggleableState.Off -> ToggleableState.On
                                    ToggleableState.On -> ToggleableState.Indeterminate
                                    ToggleableState.Indeterminate -> ToggleableState.Off
                                }
                            }
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Column {
                            Text("Flexible with dates")
                            Text(
                                text = when (dateFlexibility) {
                                    ToggleableState.On -> "Yes"
                                    ToggleableState.Off -> "No"
                                    ToggleableState.Indeterminate -> "Maybe"
                                },
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }
                }

                Button(onClick = { showDateDialog = true }) {
                    Icon(Icons.Default.DateRange, contentDescription = null)
                    Spacer(modifier = Modifier.width(6.dp))
                    Text("Choose Date")
                }
            }
        }
    }

    if (showDateDialog) {
        AlertDialog(
            onDismissRequest = { showDateDialog = false },
            confirmButton = {
                Button(onClick = { showDateDialog = false }) {
                    Text("Done")
                }
            },
            title = { Text("Date picker flow") },
            text = {
                Text("You can attach DatePicker/DateRangePicker here based on your booking flow.")
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun TravelPlannerScreenPreview() {
    TravelPlannerScreen()
}

