package com.example.androidcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import com.example.androidcompose.ui.screens.Hello
import com.example.androidcompose.ui.theme.AndroidComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidComposeTheme {
                // This is the entry point into our app
                DisplayUI()
            }
        }
    }
}

@Composable
fun DisplayUI() {

    // Display the home screen
    //Home()

    // Display the hello screen
    Hello()
}

