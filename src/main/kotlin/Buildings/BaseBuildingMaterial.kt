package Buildings

open class BaseBuildingMaterial(){
    open val numberNeeded = 1
}

class Wood():BaseBuildingMaterial(){
    override val numberNeeded = 4
}

class Brick():BaseBuildingMaterial(){
    override val numberNeeded = 8
}

class Building<T:BaseBuildingMaterial>(private val basebuildingMaterial: T){
    private val baseMaterialsNeeded = 100
    private val actualMaterialNeeded = basebuildingMaterial.numberNeeded * baseMaterialsNeeded
    fun build(){
        println("Type material: ${basebuildingMaterial::class.simpleName} quantity: $actualMaterialNeeded ")
    }
}

fun main(args: Array<String>) {
    val wood = Building<Wood>(Wood())
    wood.build()
}