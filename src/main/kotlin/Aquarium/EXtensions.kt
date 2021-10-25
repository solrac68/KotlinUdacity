package Aquarium

fun String.hasSpaces(): Boolean {
    val found:Char? = this.find{it == ' '}
    return found != null
}

fun String.hasSpaces2() = find {it == ' '} != null

fun extensionsExample(){
    "Does it have spaces'".hasSpaces() // true
    "Does it have spaces".hasSpaces2() // true
}

class AquariumPlant(val color: String, private val size: Int)
fun AquariumPlant.isRed() = color == "Red"
//fun AquariumPlant.isBig() = size > 50 // size it is private in AquariumPlant

open class AquariumPlant2(val color: String, private val size: Int)
class GreenLeafyPlant(size: Int): AquariumPlant2("Green", size)
fun AquariumPlant2.isRead() = color == "Read"

fun AquariumPlant2.print() = println("AquariumPlant")
fun GreenLeafyPlant.print() = println("GreenLeafyPlant")

fun staticExample(){
    val plant = GreenLeafyPlant(size = 50)
    plant.print() // GreenLeafyPlant

    val aquariumPlant2: AquariumPlant2 = plant
    aquariumPlant2.print() // AquariumPlant
}

val AquariumPlant.isGreen: Boolean
    get() = color == "Green"

fun propertyExample(){
    val plant = AquariumPlant("Green", 50)
    plant.isGreen // true
}

fun AquariumPlant?.pull(){
    this?.apply {
        println("removing $this")
    }
}

fun nullableExample(){
    val plant: AquariumPlant? = null
    plant.pull()
}