class Functions {

    /*
    Calcula el promedio de una lista de enteros
     */
    fun calculateAverage(numbers: List<Int>): Int {
        return (numbers.reduce { acc, num -> acc + num })/numbers.size;
    }

    /*
    Recibe una lista de enteros y devuelve una lista con solo impares
     */
    fun Filter(numbers: List<Int>): List<Int> {
        return numbers.filter { it % 2 != 0 };

    }

    /*
    Devuelve un booleano dependiendo si la palabra pasada es palindroma o no
     */
    fun isPalindrome (word: String): Boolean{ return (word == word.reversed())}

    /*
    Crea un saludo por cada persona en la lista
     */
    fun salute(names: List<String>): List<String> {
        return names.map { "Hi, $it!\n" }

    }

    /*
    Creacion de una operacion lambda de suma/resta
     */
    fun performOperation(a: Int, b: Int, operation: (Int, Int) -> Int): Int {
        return operation(a, b)
    }

    /*
    Recibe como paramero un objeto tipo Person y devuelve uno tipo Student
     */
    fun personToStudent (person: Person) : Student {
        return Student(person.name, person.age, person.gender, "N/A")
    }

}