package Generics

import Buildings.Building
import Buildings.Wood
import java.awt.AWTError

open class WaterSupply(var needsProcessed: Boolean)

class TapWater: WaterSupply(true){
    fun addChemicalCleaners(){
        needsProcessed = false
    }
}

class FishStoreWater: WaterSupply(false)

class LakeWater: WaterSupply(true){
    fun filter(){
        needsProcessed = false
    }
}

class Aquarium<out T:WaterSupply>(val waterSupply: T){
    fun addWater(cleaner: Cleaner<T>) {
        //check(!waterSupply.needsProcessed) {"water supply needs processed"}
        if(waterSupply.needsProcessed) {
            cleaner.clean(waterSupply)
        }
        println("adding water from $waterSupply")
    }
}

fun genericExample(){
    //val aquarium = Aquarium<TapWater>(TapWater())
    val aquarium = Aquarium(TapWater())
    aquarium.waterSupply.addChemicalCleaners()

    //val aquarium2 = Aquarium<String>("String") // No es posible por que no es del típo T correcto debe heredar de WaterSupply
    //println(aquarium2.waterSupply)

    //val aquarium3 = Aquarium(null) // No es posible por que no es del típo T correcto debe heredar de WaterSupply
    //aquarium3.waterSupply

    val aquarium4 = Aquarium(LakeWater())
    aquarium4.waterSupply.filter()
    //aquarium4.addWater()
}

fun main(args: Array<String>) {
    //val wood = Building<Wood>(Wood())
    //wood.build()
    genericExample3()
}

interface Cleaner<in T: WaterSupply>{
    fun clean(waterSupply: T)
}

class TapWaterCleaner: Cleaner<TapWater>{
    override fun clean(waterSupply: TapWater) {
        waterSupply.addChemicalCleaners()
    }
}

fun addItemTo(aquarium: Aquarium<WaterSupply>) = println("Item added")

fun genericExample2(){
    val aquarium = Aquarium(TapWater())

    addItemTo(aquarium) // ES posible por que la clase Aquarium es marcada cómo out Aquarium<out T:WaterSupply>
}

fun genericExample3(){
    val cleaner = TapWaterCleaner()

    val aquarium = Aquarium(TapWater())
    aquarium.addWater(cleaner)

}