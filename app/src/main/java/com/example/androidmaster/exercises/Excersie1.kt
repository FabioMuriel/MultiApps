package com.example.androidmaster.exercises

fun main() {

    val morningNotification = 51;
    val evenNotification = 135;

    printNotificationSummary(morningNotification);
    printNotificationSummary(evenNotification);

}

fun printNotificationSummary(numberOfMessage: Int) {

    if(numberOfMessage <= 99){
        println("You have a $numberOfMessage notifications.")
    }
    else{
        println("You phone is blowing up! You have +99 notifications.")
    }
}