package Generics

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

class Aquarium<T:WaterSupply>(val waterSupply: T){
    fun addWater() {
        check(!waterSupply.needsProcessed) {"water supply needs processed"}
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
    aquarium4.addWater()
}