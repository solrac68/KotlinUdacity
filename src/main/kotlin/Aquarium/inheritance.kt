package Aquarium

fun main(args: Array<String>){
    delegate()
}

fun delegate() {
    val pleco = Plecostomus()
    println("Fish has color ${pleco.color}")
    pleco.eat()
}

interface FishAction{
    fun eat()
}

interface FishColor{
    var color: String
}

object GoldColor: FishColor {
    override var color: String = "gold"
}

object RedColor: FishColor{
    override var color: String = "red"
}

class Plecostomus():
    FishAction by PrintingFishAction("a lot of algae"),
    FishColor by GoldColor

class PrintingFishAction(val food: String): FishAction {
    override fun eat() {
        println(food)
    }
}

