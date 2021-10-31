package Aquarium5

import java.util.*

data class Fish (var name: String)

fun main(args: Array<String>){
    //fishExamples()
    exampleList()
}

fun fishExamples() {
    val fish = Fish("splashy")

    myWith(fish.name){
        println(capitalize())
    }
    println(fish.run{name})
    println(fish.apply{})

    val fish2 = Fish(name = "splashy").apply { name = "Sharpy" }

    println(fish.let{it.name.capitalize()}.let{it + "fish"}.let{it.length}.let{it + 31})
}

fun myWith(name: String, block: String.() -> Unit){
    name.block()
}

fun exampleList(){
    val numbers = listOf<Int>(1,2,3,4,5,6,7,8,9)
    print(numbers.divisibleBy { it.rem(3) })
}

fun List<Int>.divisibleBy(block:(Int) -> Int): List<Int> {
    val result = mutableListOf<Int>()
    for(item in this){
        if(block(item) == 0){
            result.add(item)
        }
    }
    return result
}