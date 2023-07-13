package be.webmobile.kotlin.exo.functions

import kotlin.random.Random


fun generateSortedCopy(origin: Array<Int>): Array<Int>{
    val copy = origin.copyOf()
    copy.sort()
    return copy
}

fun getFilteredElement(origin: Array<String>, predicate: (element: String) -> Boolean ): List<String> {
    // facon 1
    val filteredElements: MutableList<String> = mutableListOf()
    for (element in origin) {
        if( predicate( element ) )
            filteredElements.add(element)
    }
    return filteredElements;
    // facon 2 - utilisation des stream java
//    return Arrays.stream( origin )
//        .filter( predicate )
//        .toList()
}

fun main() {
    val tabInt = Array(10) { Random.nextInt(1,101) }
    println("avant: ${tabInt.joinToString(", ")}")
    val sortedCopy = generateSortedCopy(tabInt)
    println("après: ${sortedCopy.joinToString(", ")}")
    println("origine: ${tabInt.joinToString(", ")}") // seule la copie a été modifiée

    val tabString = arrayOf("Luc", "dominique", "Marie")
//    val majElements = getFilteredElement( tabString ) { element -> element.first() in 'A'..'Z' }
    val majElements = getFilteredElement( tabString ) { it.first() in 'A'..'Z' }
//    val majElements = getFilteredElement( tabString ) { it.matches(Regex("^[AZ]+$")) }
    println("maj: ${majElements.joinToString(", ")}")
//    val lengthElements = getFilteredElement( tabString ) { element -> element.length >= 5 }
    val lengthElements = getFilteredElement( tabString ) { it.length >= 5 }
    println("length: ${lengthElements.joinToString(", ")}")

}