package be.webmobile.kotlin.demo.interaction

fun main() {

    println("""
        Ecrire en console
        fnoefn
    """.trimIndent()) // Vire les indentation(/tab) du code dans la chaine de charactère

    val input = readln().toInt()

    println("mon input: $input") // pour integrer un variable on peut utiliser $variable
    println("mon input plus 5: ${input + 5}") // pour integrer la valeur d'une expression ${expression}

}