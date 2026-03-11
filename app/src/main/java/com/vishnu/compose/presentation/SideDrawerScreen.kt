package com.vishnu.compose.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun SideDrawerScreen() {

    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(

        drawerState = drawerState,

        drawerContent = {

            ModalDrawerSheet {

                Text(
                    "Home",
                    modifier = Modifier.padding(16.dp)
                )

                Text(
                    "Profile",
                    modifier = Modifier.padding(16.dp)
                )

                Text(
                    "Settings",
                    modifier = Modifier.padding(16.dp)
                )
            }
        }

    ) {

        Scaffold(

            topBar = {

                TopAppBar(

                    title = { Text("Compose Demo") },

                    navigationIcon = {

                        IconButton(
                            onClick = {
                                scope.launch {
                                    drawerState.open()
                                }
                            }
                        ) {
                            Icon(Icons.Default.Menu, null)
                        }
                    }
                )
            },

            bottomBar = {

                BottomAppBar {

                    IconButton(onClick = {}) {
                        Icon(Icons.Default.Home, null)
                    }

                    IconButton(onClick = {}) {
                        Icon(Icons.Default.Person, null)
                    }

                }
            },

            floatingActionButton = {

                FloatingActionButton(
                    onClick = {}
                ) {
                    Icon(Icons.Default.Add, null)
                }

            }

        ) { padding ->

            LazyColumn(
                modifier = Modifier
                    .padding(padding)
                    .fillMaxSize()
            ) {

                items(30) {

                    Text(
                        text = "List Item $it",
                        modifier = Modifier
                            .padding(16.dp)
                    )
                }
            }
        }
    }
}