package com.example.androidcompose

import androidx.lifecycle.ViewModel
import com.example.androidcompose.models.Address
import com.example.androidcompose.models.Person
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel: ViewModel() {
    private val _person = MutableStateFlow<Person?>(null)
    val person = _person.asStateFlow()

    init {
        // Create a person
        val person = Person(
            firstName = "Han",
            lastName = "Solo",
            email = "han.solo@hotmail.com",
            addresses = listOf(
                Address(
                    street = "1234 Main St",
                    city = "Toronto",
                    province = "ON",
                    postalCode = "M5V 2N6",
                    country = "Canada"
                ),
                Address(
                    street = "122 Some St",
                    city = "Halifax",
                    province = "NS",
                    postalCode = "B4A 2M5",
                    country = "Canada"
                )
            )
        )

        // set the value of person
        _person.value = person
    }
}