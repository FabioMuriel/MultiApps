package com.example.androidmaster.sintaxys

fun main(){
    //inmutableList()
    mutableList()
}

fun mutableList() {
    var weeDays:MutableList<String> = mutableListOf("Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domiengo");
    weeDays.add(0, "FabioDay");

    if(weeDays.isEmpty()){
        print("No hay dias de la semana registrados")
    }

    println(weeDays);
}

fun inmutableList() {

    val readOnly:List<String> = listOf("Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domiengo");

    println(readOnly.size);
    println(readOnly);
    println(readOnly.first());
    println(readOnly.last());

    //Filtrar
    val example = readOnly.filter { it.contains("a")  };
    println(example);

    readOnly.forEach{ weekDay -> println(weekDay)}

}

