/**
 * Universidad del Valle de Guatemala
 * Author: Irving Acosta - 22781
 * Section:20
 * Description: Laboratory 02
 * Last modicated: 20.07.2023
 */

import java.util.StringJoiner

class Main {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val driver: Functions = Functions()

            println("*------Laboratorio 02-----*")

            println("\nCalcular Promedio")
            val numbers: List<Int> = listOf(10, 20, 30, 40)
            println( "El promedio de la lista " + numbers.toString() + "es: " + driver.calculateAverage(numbers).toString())

            println("\nLista de Impares")
            val numbers2: List<Int> = listOf(23, 10, 11, 40, 19, 2)
            println("Lista completa: $numbers2")
            val odds: List<Int> = driver.Filter(numbers2)
            println("Lista de impares: $odds")

            println("\nEs Palindromo")
            val word: String = "hola"
            val word2: String = "seres"
            println("La palabra ($word) es un palindromo: " + driver.isPalindrome(word))
            println("La palabra ($word2) es un palindromo: " + driver.isPalindrome(word2))

            println("\nSaludo")
            val names: List<String> = listOf("Emy", "Irving","Ima", "Lana del Rey")
            println(driver.salute(names).toString())

            println("\nLambda Funtion")
            val suma: (Int, Int) -> Int = { x, y -> x + y }
            val resta: (Int, Int) -> Int = { x, y -> x - y }

            val resultadoSuma = driver.performOperation(20, 3, suma)
            val resultadoResta = driver.performOperation(19, 7, resta)

            println("El resultado de la suma es: $resultadoSuma\nEl resultado de la resta es: $resultadoResta")

            println("\nPerson to Student")
            val persona01:Person = Person("Emy",19,"female")
            val person02: Person= Person("Irving",18,"male")

            val estudiante01: Student = driver.personToStudent(persona01)
            val estudiante02: Student = driver.personToStudent(person02)

            val listStudent: List<Student> = listOf(estudiante01,estudiante02)

            println(listStudent.map { "El estudiante ${it.name} tiene ${it.age} de edad\n" })

        }
    }
}