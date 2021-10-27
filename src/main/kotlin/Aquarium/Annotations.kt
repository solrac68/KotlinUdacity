package Aquarium

import kotlin.reflect.full.declaredFunctions
import kotlin.reflect.full.findAnnotation

@ImAPlant class Plant {
    fun trim() {}
    fun fertilize() {}

    @get:OnGet
    val isGrowing:Boolean = true

    @set:OnSet
    var needsFood: Boolean = false


}

annotation class ImAPlant

@Target(AnnotationTarget.PROPERTY_GETTER)
annotation class OnGet

@Target(AnnotationTarget.PROPERTY_SETTER)
annotation class OnSet

fun refletions(){
    val classObj = Plant::class

//    for(method in classObj.declaredFunctions){
//        println(method.name)
//    }

    for(ann in classObj.annotations){
        println(ann.annotationClass.simpleName)
    }

    val annotated = classObj.findAnnotation<ImAPlant>()
    annotated?.apply { println("Found a plant annotation!") }

}

fun main(args: Array<String>) {
    refletions()
}