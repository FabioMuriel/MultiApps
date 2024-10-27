package com.example.androidmaster.sintaxys

//VARIABLES

fun main() {

    //Int
    val intExample: Int = 19;

    //Long
    val longExample: Long = 9091283;

    //Float
    val floatExample: Float = 12.6f;

    //Double
    val doubleExample: Double = 16.87623476;

    //Char
    val charExample: Char = 'a';

    //String
    val stringExample: String = "FabioMaster Next AndroidDeveloper";

    //Boolean
    val booleanExample: Boolean = true;

    println(stringExample);
    showMyName("Fabio");
    println(sumTwoNumber(10, 20));

}

//Function
fun showMyName(name: String) {
    println("Mi nombre es $name");
}

fun sumTwoNumber(num1:Int, num2:Int) : Int = num1 + num2;
