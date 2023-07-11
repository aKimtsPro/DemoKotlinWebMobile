package be.webmobile.kotlin.exo.collection

fun main() {

    val joueursSansEquipe: MutableList<String> = mutableListOf()
    val equipes: MutableMap<String, MutableList<String>> = mutableMapOf()

    var input: Int;

    do {
        println("""
            MENU
            1 - ajouter joueur
            2 - ajouter equipe
            3 - ajouter joueur dans equipe
            4 - afficher membre d'une equipe
            5 - quitter
        """.trimIndent())

        input = readln().toInt()

        when(input) {
            1 -> {
                println("Quel nom?")
                joueursSansEquipe.add( readln() )
            }
            2 -> {
                println("quel nom?")
                val nom = readln()
                if( nom !in equipes.keys )
                    equipes[nom] = mutableListOf()
//                    equipes.put( nom, mutableListOf() ) // pareil
                else
                    println("Cette equipe existe déjà")
            }
            3 -> {
                println("Nom de l'equipe?")
                val nomEquipe = readln()
                if( nomEquipe in equipes.keys ){
                    println("Nom du joueur?")
                    val nomJoueur = readln()
                    if( nomJoueur in joueursSansEquipe ) {
                        joueursSansEquipe.remove(nomJoueur)
                        equipes[nomEquipe]!!.add(nomJoueur)
                        println("Le joueur $nomJoueur a été ajouté à $nomEquipe")
                    } else {
                        println("Le joueur n'existe pas ou a déjà intégré une équipe")
                    }
                }
                else {
                    println("L'équipe n'existe pas")
                }
            }
            4 -> {
                println("Quelle equipe?")
                val nomEquipe = readln()
                if( nomEquipe in equipes.keys ){
                    println("-- Equipe $nomEquipe --")

                    // Facon 1
//                    val equipe = equipes[nomEquipe]
//                    if( equipe != null ){
//                        for (s in equipe) {
//                            println("- $s")
//                        }
//                    }
                    // facon 2
//                    for (membre in equipes[nomEquipe]!!){ // raccourci de la méthode .get(key)
                    // facon 3
//                    for (membre in equipes.get(nomEquipe)!!){
                    // facon 4
                    for (membre in equipes.getValue(nomEquipe)){
                        println("- $membre")
                    }
                }
                else {
                    println("L'equipe n'existe pas")
                }
            }
            5 -> println("au revoir")
            else -> println("commande invalide")
        }

    } while ( input != 5 );

}