import java.util.*
import kotlin.collections.ArrayList

fun main(args: Array<String>) {
    println("Hello, ${args[0]}")
    feedTheFish()
    println(canAddFish(10.0, listOf(3,3,3)))
    println(canAddFish(8.0, listOf(2,2,2),hasDecorations = false))
    println(canAddFish(9.0, listOf(1,1,3),3))
    println(canAddFish(10.0, listOf(),7,true))

    var bubbles = 0
    while (bubbles < 50){
        bubbles++
    }

    repeat(2){
        println("A fish is swimming")
    }
}

fun getDirtySensorReading() = 20

fun shouldChangeWater(
    day: String,
    temperature: Int = 22,
    dirty: Int = getDirtySensorReading()
): Boolean{
    val isTooHot = temperature > 30
    val isDirty = dirty > 30
    val isSunday = day == "Sunday"

    return when {
        isTooHot(temperature) -> true
        isDirty(dirty) -> true
        isSunday(day) -> true
        else -> false
    }
}
fun isTooHot(temperature:Int) = temperature > 30
fun isDirty(dirty: Int) = dirty > 30
fun isSunday(day: String) = day == "Sunday"

fun feedTheFish(){
    val day = randomDay()
    val food = fishFood(day)
    println("Today is $day and the fish eat $food")
    swim(50,speed = "slow")
    shouldChangeWater(day, temperature = 20, dirty = 50)
    shouldChangeWater(day)
    shouldChangeWater(day, dirty = 50)

    if(shouldChangeWater(day)){
        println("Change the water today")
    }
}

fun swim(time:Int, speed: String = "fast"){
    println("swimming $speed")
}

fun randomDay(): String {
    val week = listOf("Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday")
    return week[Random().nextInt(7)]
}

fun fishFood(day: String):String{
    return when(day) {
        "Monday" -> "flakes"
        "Tuesday" -> "pellets"
        "Wednesday" -> "redworms"
        "Thursday" -> "granules"
        "Friday" -> "moquitoes"
        "Saturday" -> "lettuce"
        "Sunday" -> "plankton"
        else -> "fasting"
    }
}

fun canAddFish(tankSize:Double,
               currentAddFish:List<Int>,
               fishSize:Int=2,
               hasDecorations:Boolean=true):Boolean{

    val tankSizeReal:Double = when {
        hasDecorations -> 0.8 * tankSize
        else -> tankSize
    }

    val sumFishCurrent = currentAddFish.sum() + fishSize

    return  sumFishCurrent <= tankSizeReal

}

var dirty = 20
val waterFilter: (Int)-> Int = {dirty: Int -> dirty/2}
fun feedFish(dirty: Int) = dirty + 10
fun updateDirty(dirty: Int, operation: (Int) -> Int):Int {
    return operation(dirty)
}
fun dirtyProcessor(){
    dirty = updateDirty(dirty,waterFilter)
    dirty = updateDirty(dirty,::feedFish)
    dirty = updateDirty(dirty){dirty -> dirty + 50}
//  dirty = updateDirty(dirty,{ dirty ->
//      dirty + 50
//  })
}

