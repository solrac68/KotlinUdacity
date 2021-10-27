package Aquarium

fun main(args: Array<String>) {
    println("Hello, ${args[0]}")
    println("Test Clases")

    val inicio = InitOrderDemo("Andrew")
    val segundo = Customer("Andres")
    val person = Person(firstName = "Carlos", lastName = "Augusto", age = 50)

    println("La personas es: $person.firstName $person.lastName y tiene $person.age")

    //https://kotlinlang.org/docs/classes.html#constructors
}

class InitOrderDemo(name: String) {
    val firstProperty = "First property: $name".also(::println)

    init {
        println("First initializer block that prints $name")
    }

    val secondProperty = "Second property: ${name.length}".also(::println)

    init {
        println("Second initializer block that prints ${name.length}")
    }
}

class Customer(name: String) {
    @OptIn(ExperimentalStdlibApi::class)
    val customerKey = name.uppercase()

    init {
        println("First initializer block that prints $customerKey")
    }
}

class Person(val firstName: String, val lastName: String, var age: Int)

