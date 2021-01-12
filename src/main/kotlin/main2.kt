import java.util.*

/*

Fare stessa cosa della funzione toStack, senza utilizzare STACK, partendo dalla fine della stringa.
Senza utilizzare nessuna struttura di dati.

*/

fun main() {
    println(confrontaStringheHash("azz","aubc##zz"))
}

fun confrontaStringheHash(stringa1: String, stringa2: String): Boolean {
//    val primoStack = stringa1.toStack()
//    val secondoStack = stringa2.toStack()
    return stringa1.toStack()==stringa2.toStack()
}

fun String.toStack(): Stack<Char> {
    val pila = Stack<Char>()
    for(c in this) {
        if(c=='#') {
            if(!pila.empty()) {
                pila.pop()
            }
        } else {
            pila.push(c)
        }
    }
    return pila
}



// azz   aub##zz

// usando struttura dati STACK