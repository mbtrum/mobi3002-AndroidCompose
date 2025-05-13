package com.example.androidcompose.models

data class Person (
    val firstName: String,
    val lastName: String,
    val email: String,
    val addresses: List<Address>
)

data class Address (
    val street: String,
    val city: String,
    val province: String,
    val postalCode: String,
    val country: String
)