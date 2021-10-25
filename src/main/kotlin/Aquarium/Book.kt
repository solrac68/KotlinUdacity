package Aquarium

import java.util.*

fun main(args: Array<String>) {
    val puppy = Puppy()
    val book = Book("Oliver Twist","Charles Dickens", 1837, 540)

    while(book.pages > 0){
        puppy.playWithBook(book)
        println("${book.pages} left in ${book.title}")
    }
}


open class Book(val title: String = "Las mil y una noche", val author: String = "Aljuarismi", val year:Int, var pages:Int){
    var currentPage: Int = 0
    open fun readPage(){
        ++currentPage
    }
}

class eBook(title: String, author: String, var format: String = "text", year: Int, pages: Int):Book(title,author,year,pages){
    private var wordsRead = 0
    override fun readPage() {
        wordsRead += 250
    }
}
const val MAX_NUMBER_BOOKS = 20
fun canBorrow(hasBooks: Int): Boolean {
    return (hasBooks < MAX_NUMBER_BOOKS)
}
object Constants {
    const val BASE_URL = "http://www.turtlecare.net"
}
fun printUrl(title:String){
    println(Constants.BASE_URL + title + ".html")
}

fun Book.weight():Double {return (this.pages* 1.5)}

fun Book.tornPages(torn: Int) = if (pages >= torn) pages -= torn else pages = 0

class Puppy(){
    fun playWithBook(book: Book) {
        book.tornPages(Random().nextInt(12))
    }
}

