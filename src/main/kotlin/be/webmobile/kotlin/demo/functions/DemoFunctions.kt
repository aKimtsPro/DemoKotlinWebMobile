package be.webmobile.kotlin.demo.functions

import java.util.*

fun main() {

    afficherNombre()
    salutuation( salue = "dominique", saleur = "marie" ); // utilisation de param nommé
// permet d'appeler la méthode dans respecter l'ordre des params

    // Les fonctions lambdas

    var a: (a: Int, b: Int) -> Unit; // typage de fonctions pour les variables contenant des lambdas
    a = { a,b -> println(a*b) }// les lambdas s'ecrivent entre {...}. Pas des (...) pour entourer les params.
    // si il y a plusieurs instructions:
    a = { a, b -> run {
            val rslt = a * b
            println(rslt)
        }
    }

    // execution de la lambda:
    a(5,6)


    val tab = arrayOf("ok", "ko", "kokok")
    // si mon dernier param est une lambda je peux la sortir des paramètres:
    applyOnEach(tab, { element -> println(element) })
    applyOnEach(tab) { element -> println(element) } // pareil que la ligne précédente
    applyOnEach(tab) { println(it) } // pareil que la ligne précédente (on peut utiliser it si la lambda n'a qu'un seul param)
    applyOnEach(tab) { element -> println(element.uppercase()) }
    applyOnEach(tab) { element -> println(element.length) }
    // si pas d'autre param,  je peux ne pas mettre de parenthèse
    run/*()*/ {  -> println("ma lambda") }
    // run est une fonction


}

// function - a un retour
fun addition(a: Int, b: Int): Int {
    return a + b
}

// procedure - n'a pas de retour - Type de retour Unit(pas de retour) - la declaration du type de retour n'est pas nécessaire
fun afficherNombre(nombre: Int = 0): Unit { // nombre est un param optionnel
    println(nombre)
}

// si une procédure n'a qu'une seule instruction, on peut directement ecrire la fonction de la manière suivante
fun salutuation(saleur: String, salut: String = "bonjour", salue: String = "Luc") {
    println("$salut $salue, je suis $saleur")
}
fun salutuationBis(saleur: String, salut: String = "bonjour", salue: String = "Luc") =
    println("$salut $salue, je suis $saleur")


// fonction single-value: lorsqu'on a pas besoin de multiple instruction pour calculer le retour,
// on peut directement marque "= <le retour en question>"
fun add(a: Int, b: Int): Int = a + b

// Applique "action" sur chaque élément du tableau
// Quand je déclare avec un type de fonction retournant Unit, je dois le mettre
fun applyOnEach(tab: Array<String>, action: (element: String) -> Unit ){
    for (element in tab) {
        action(element)
    }
}
