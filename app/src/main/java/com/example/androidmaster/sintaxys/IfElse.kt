package com.example.androidmaster.sintaxys

fun main() {
    ifBasic()
}

fun ifBasic() {

    val name = "Fabio";

    if (name == "Fabio") {
        println("Oye, la variable name is Fabio");
    } else {
        println("Este no es Fabio");
    }

}

fun ifAnidado() {
    val animal: String = "Perro";

    if (animal == "Perro") {
        println("Es un perro");
    } else if (animal == "Gato") {
        println("Es un gato");
    }

    result(true)
}

fun getSemestre(semestre:Int) {
    val semestreResult = when (semestre) {
        in 1..6 -> println("Primer semestre")
        in 7..12 -> println("Segundo Semestre")
        else -> println("No es un semestre no valido")
    }

    return semestreResult;
}

fun result(value: Any) {
    when (value) {
        is Int -> println("Es un number")
        is String -> println("Es un string")
        is Boolean -> println("Es un boolean")
        else -> println("Unknown data type")
    }
}
