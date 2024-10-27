package com.example.androidmaster.sintaxys

fun main(){

    val weekOfDays = arrayOf("Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo");

    //println(weekOfDays[weekOfDays.size - 1]);

    //Bucles para array
    for(position in weekOfDays){
        println(position);
    }

    for((position, value) in weekOfDays.withIndex()){
        println("El indice $position contiene el dia $value");
    }
}