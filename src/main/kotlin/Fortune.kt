fun main(args: Array<String>) {
    var fortune:String = ""
    while(!fortune.contains("Take it easy")) {
        fortune = getFortuneCookie(getBirthday())
        println("Your fortune is: $fortune")
        //if (fortune == "Take it easy and enjoy life!") break
    }
}

fun getFortuneCookie(birthday:Int):String{
    //val birthday : String? = null
    val fortunes = listOf("You will have a great day!",
        "Things will go well for you today.",
        "Enjoy a wonderful day of success.",
        "Be humble and all will turn out well.",
        "Today is a good day for exercising restraint.",
        "Take it easy and enjoy life!",
        "Treasure your friends because they are your greatest fortune.")

    return when (birthday){
        28, 29 -> "Felicidad máxima"
        in (1..7) -> "Aquietate"
        else -> fortunes[birthday % fortunes.size]

    }
    //return fortunes[birthday % fortunes.size]
}

fun getBirthday():Int{
    print("Enter your birthday: ")
    return readLine()?.toIntOrNull() ?: 0
}
