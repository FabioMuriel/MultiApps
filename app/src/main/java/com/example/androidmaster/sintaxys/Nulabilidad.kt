package com.example.androidmaster.sintaxys

fun main() {
    val name: String? = null;

    println(name?.get(3) ?: "El valor es null" );
}