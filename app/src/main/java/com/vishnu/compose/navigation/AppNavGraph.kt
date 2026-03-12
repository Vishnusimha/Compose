package com.vishnu.compose.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.vishnu.compose.PracticeScreen
import com.vishnu.compose.presentation.BestPracticeScreen
import com.vishnu.compose.presentation.CreatorStudioScreen
import com.vishnu.compose.presentation.FoodDeliveryScreen
import com.vishnu.compose.presentation.NetflixInspiredScreen
import com.vishnu.compose.presentation.PinterestInspiredScreen
import com.vishnu.compose.presentation.SideDrawerScreen
import com.vishnu.compose.presentation.SpotifyInspiredScreen
import com.vishnu.compose.presentation.SpotifyRealisticScreen
import com.vishnu.compose.presentation.TravelPlannerScreen
import com.vishnu.compose.presentation.UnusedComponentsShowcaseScreen

private data class DemoDestination(
    val route: String,
    val title: String,
    val content: @Composable () -> Unit
)

private const val HOME_ROUTE = "home"

private val demoDestinations = listOf(
    DemoDestination(route = "practice", title = "Practice Basics", content = { PracticeScreen() }),
    DemoDestination(
        route = "best_practice",
        title = "Best Practice",
        content = { BestPracticeScreen() }),
    DemoDestination(
        route = "netflix",
        title = "Netflix Inspired",
        content = { NetflixInspiredScreen() }),
    DemoDestination(
        route = "spotify",
        title = "Spotify Inspired",
        content = { SpotifyInspiredScreen() }),
    DemoDestination(
        route = "spotify_realistic",
        title = "Spotify Realistic",
        content = { SpotifyRealisticScreen() }),
    DemoDestination(
        route = "pinterest",
        title = "Pinterest Inspired",
        content = { PinterestInspiredScreen() }),
    DemoDestination(route = "side_drawer", title = "Side Drawer", content = { SideDrawerScreen() }),
    DemoDestination(
        route = "creator_studio",
        title = "Creator Studio",
        content = { CreatorStudioScreen() }),
    DemoDestination(
        route = "food_delivery",
        title = "Food Delivery",
        content = { FoodDeliveryScreen() }),
    DemoDestination(
        route = "travel_planner",
        title = "Travel Planner",
        content = { TravelPlannerScreen() }),
    DemoDestination(
        route = "unused_showcase",
        title = "Unused Components Showcase",
        content = { UnusedComponentsShowcaseScreen() })
)

@Composable
fun AppNavGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = HOME_ROUTE
    ) {
        composable(HOME_ROUTE) {
            LandingScreen(
                destinations = demoDestinations,
                onDestinationClick = { destination ->
                    navController.navigate(destination.route) {
                        launchSingleTop = true
                        restoreState = true
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                    }
                }
            )
        }

        demoDestinations.forEach { destination ->
            composable(destination.route) {
                destination.content()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun LandingScreen(
    destinations: List<DemoDestination>,
    onDestinationClick: (DemoDestination) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Compose Demo Hub") }
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            item {
                Text(
                    text = "Tap a screen to open it. Press system back to return here.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            items(destinations) { destination ->
                ElevatedButton(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = { onDestinationClick(destination) }
                ) {
                    Text(
                        text = destination.title,
                        modifier = Modifier.weight(1f)
                    )
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                        contentDescription = null
                    )
                }
            }
        }
    }
}
