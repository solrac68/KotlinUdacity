package Aquarium6

fun main(args: Array<String>){
    println("fishExamples")
    fishExamples()
}

data class Fish(val name: String)

fun fishExamples(){
    val fish = Fish("splashy")
    //println(fish.name)

    // without inline an object is created every call to myWith
    myWith(fish.name, object: Function1<String, Unit> {
        override fun invoke(name: String) {
            name.capitalize()
        }
    })

    println(fish.name.capitalize())
}

inline fun myWith(name: String, block: String.() -> Unit){
    name.block()
}