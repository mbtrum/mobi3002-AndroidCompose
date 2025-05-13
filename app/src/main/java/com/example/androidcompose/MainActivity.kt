package com.example.androidcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.androidcompose.ui.screens.Hello
import com.example.androidcompose.ui.screens.Home
import com.example.androidcompose.ui.theme.AndroidComposeTheme

class MainActivity : ComponentActivity() {

    // define view model
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidComposeTheme {
                // initialize view model
                mainViewModel = viewModel()

                // This is the entry point into our app. Pass in the view model
                DisplayUI(mainViewModel)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DisplayUI(mainViewModel: MainViewModel) {

    // Add nav controller
    val navController = rememberNavController()

    // Selected index for the nav bar
    var selectedIndex by remember { mutableIntStateOf(0) }

    //val person by mainViewModel.person.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Android Compose")
                },
                // add colors for the top app bar
                colors = TopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                    scrolledContainerColor = MaterialTheme.colorScheme.primaryContainer,
                    navigationIconContentColor = MaterialTheme.colorScheme.primary,
                    actionIconContentColor = MaterialTheme.colorScheme.primary
                )
            )
        },
        bottomBar = {
            NavigationBar(
                // add colors for the navigation bar
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.primary
            ) {
                NavigationBarItem(
                    label = { Text("Home") },
                    onClick = {
                        selectedIndex = 0
                        navController.navigate("home") },
                    selected = selectedIndex == 0,
                    icon = { Icon(
                        painter = painterResource(id = R.drawable.ic_action_home),
                        contentDescription = "Home") }
                )
                NavigationBarItem(
                    label = { Text("Hello") },
                    onClick = {
                        selectedIndex = 1
                        navController.navigate("hello") },
                    selected = selectedIndex == 1,
                    icon = { Icon(
                        painter = painterResource(id = R.drawable.ic_action_hello),
                        contentDescription = "Hello") }
                )
            }
        }
    ) { innerPadding ->

        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = "home") {
                Home()
            }
            composable(route = "hello") {
                Hello(mainViewModel)
            }
        }
    }
}

