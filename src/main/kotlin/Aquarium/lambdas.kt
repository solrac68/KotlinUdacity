package Aquarium

fun main(args: Array<String>) {
    println("Hello")
    data class Fish (val name: String)
    val myFish = listOf(Fish("Flipper"),Fish("Moby Dick"), Fish("Dory"))
    val myFishFilter = myFish.filter{it.name.contains("i")}.joinToString(" "){it.name}
    println(myFishFilter)

}