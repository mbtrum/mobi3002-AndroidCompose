package com.example.androidcompose.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.androidcompose.MainViewModel
import com.example.androidcompose.R

@Composable
fun Hello(mainViewModel: MainViewModel) {

    val person = mainViewModel.person.collectAsState().value

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(state = rememberScrollState())) {

        Image(
            painter = painterResource(id = R.drawable.android_logo),
            contentDescription = "Android Logo")

        Text(text = "Hello")

        if(person != null) {
            Text(text = "${person.firstName} ${person.lastName}")

            Text(text = person.email)

            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "Addresses:")

            person.addresses.forEach { address ->
                Text(text = "${address.street}, ${address.city}, ${address.province}, ${address.postalCode}, ${address.country}")
            }
        }
        else {
            Text(text = "No person found")
        }
    }
}