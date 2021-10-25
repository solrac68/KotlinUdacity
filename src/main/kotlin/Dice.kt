import java.lang.Math.random
import kotlin.random.Random

fun main(args: Array<String>) {
    val decorations = listOf("rock","pagoda","plastic plant","alligator","flowerpot")
    println(rollDice(0))
    println(rollDice(5))
    println(rollDice(12))

    val rollDice2 = rollDice

    println(rollDice2(10))
    gamePlay(12,rollDice)

}

val rollDice: (Int)-> Int = {sides: Int -> if (sides != 0) Random.nextInt(1,sides) + 1 else 0}
fun gamePlay(sides:Int,operation:(Int) -> Int) {
    println("The side is ${operation(sides)}")
}