package Aquarium

enum class Directions {
    NORTH,
    SOUTH,
    EAST,
    WEST,
    START,
    END
}

class Game{
    private var path:MutableList<Directions> = mutableListOf<Directions>(Directions.START)
    private val north = {path.add(Directions.NORTH)}
    private val south = {path.add(Directions.SOUTH)}
    private val east = {path.add(Directions.EAST)}
    private val west = {path.add(Directions.WEST)}
    private val end = {path.add(Directions.END); println("GameOver: $path"); path.clear();false}

    private fun move(where: () -> Boolean){
        where.invoke()
    }

    fun makeMove(arg:String?){
        when (arg) {
            "n" ->  move(north)
            "s" ->  move(south)
            "e" ->  move(east)
            "w" -> move(west)
            else -> move(end)
        }
    }

}

fun main(args: Array<String>){
      val game = Game()
//    println(game.path)
//    game.north()
//    game.south()
//    game.east()
//    game.west()
//    game.end()
//    println(game.path)

    while (true){
        print("Enter a direction: n/s/e/w:")
        val dir = readLine()
        game.makeMove(dir)
    }

}