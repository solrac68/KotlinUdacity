fun main(args: Array<String>) {
    val decorations = listOf("rock","pagoda","plastic plant","alligator","flowerpot")
    println(decorations.filter { true }) // [rock, pagoda, plastic plant, alligator, flowerpot]
    //eagerExample()
    speciesExample()
}

fun eagerExample(){
    val decorations = listOf("rock","pagoda","plastic plant","alligator","flowerpot")
    val eager = decorations.filter{it[0] == 'p'}
    println(eager) // [pagoda, plastic plant]

    val filtered = decorations.asSequence().filter{it[0] == 'p'}
    //println(filtered)
    println(filtered.toList())

    val lazyMap = decorations.asSequence().map{ println("map: $it")}
    lazyMap.first()
    //println(lazyMap)
    //println("first: ${lazyMap.first()}")
}

fun speciesExample(){
    val spices = listOf("curry", "pepper", "cayenne", "ginger", "red curry", "green curry", "red pepper" )
    val spicesOrder = spices.sortedBy { it.length }
    println(spicesOrder)
    val eager = spices.filter { it.contains("curry") }.sortedBy { it.length }
    println(eager)
    val eager2 = spices.filter { it.startsWith('c') && it.endsWith('e') }
    println(eager2)
    val lazy = spicesOrder.asSequence().filter{it.startsWith('c')}.filter{it.endsWith('e')}
    println(lazy.toList())
    val eager3 = spices.take(3).filter{it.startsWith('c')}
    println(eager3)
}

