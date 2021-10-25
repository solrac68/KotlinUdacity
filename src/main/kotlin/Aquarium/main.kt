package Aquarium

fun main(args: Array<String>) {
    //buildAquarium()
    //makeFish()
}

fun buildAquarium(){
    val myAquarium = Aquarium()

    println("Length: ${myAquarium.length} " +
    "Width: ${myAquarium.width} " +
    "Height: ${myAquarium.height}")

    myAquarium.length = 120
    println("Height es: ${myAquarium.length}")

    println("El volumen es: ${myAquarium.volume}")

    val mySpice = SimpleSpice()
    println("Name: ${mySpice.name} Spice: ${mySpice.heat}")

    val smallAquarium = Aquarium(length = 20,width = 15,height = 30)
    println("Small Aquarium: ${smallAquarium.volume} liters")

    val myAquarium2 = Aquarium(numberOfFish = 5)

    println("Small Aquarium 2: ${myAquarium2.volume} liters with " +
            "length ${myAquarium2.length} " +
            "width ${myAquarium2.width} " +
            "height ${myAquarium2.height} ")


    val spice = Spice("cayenne", spiciness = "spicy")
    println("Name: ${spice.name} Grade: ${spice.heat}")

    val spices1 = listOf(
        Spice("curry", "mild"),
        Spice("pepper", "medium"),
        Spice("cayenne", "spicy"),
        Spice("ginger", "mild"),
        Spice("red curry", "medium"),
        Spice("green curry", "mild"),
        Spice("hot pepper", "extremely spicy")
    )

    val spicelist = spices1.filter {it.heat < 5}
    spicelist.forEach { println("Name: ${it.name}, Heat: ${it.heat}") }
}


//fun makeFish(){
//    //val shark = Shark()
//    val pleco = Plecostomus()
//
//    println("Shark: ${shark.color}\nPlecostomus: ${pleco.color}")
//
//    shark.eat()
//    pleco.eat()
//
//}