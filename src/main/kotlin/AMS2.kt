import java.util.*

fun main(args: Array<String>) {
    println("Hello, ${args[0]}")
    val isUnit = println("This is expression")
    println(isUnit)
    val temperature = 10
    val isHot = temperature > 50
    println(isHot)

    val message = "You are ${ if (temperature > 50) "fried" else "safe"} fish"
    println(message)

}