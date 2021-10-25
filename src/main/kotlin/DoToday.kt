fun main(args: Array<String>) {
    println(whatShouldIDoToday())
    println(whatShouldIDoToday("happy"))
}

fun whatShouldIDoToday(mood:String = inputMod(),
                       weather:String = "sunny",
                       temperature:Int = 24 ):String {
    return when {
        isTooHappy(mood,weather) -> "go for a walk"
        isTooSad(mood, weather, temperature) -> "stay in bed"
        isHot(temperature) -> "go swimming"
        else -> "Stay home and read"
    }
}

fun isTooHappy(mood:String, weather:String) = mood == "happy" && weather == "sunny"
fun isTooSad(mood:String, weather:String, temperature:Int) = mood == "sad" && weather == "rainy" && temperature == 0
fun isHot(temperature:Int) = temperature > 35
fun inputMod():String{
    print("Which is your humor: ")
    return readLine().toString()
}


