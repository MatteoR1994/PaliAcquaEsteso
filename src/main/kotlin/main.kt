import kotlin.math.max
import kotlin.math.min

fun main() {
    val pilastri = intArrayOf(1,0,2,4,0,5,3,2,0,3) // 9
    //val pilastri = intArrayOf(1,0,2,4,0,5,3,2,0,4) // 12
    //val pilastri = intArrayOf(3,0,2,4,0,5,3,2,0,4) // 15
    //val pilastri = intArrayOf(5,0,2,4,0,5,3,2,0,4) // 21
    //val pilastri = intArrayOf(5,0,0,0,0,0,0,0,0,4) // 32
    //val pilastri = intArrayOf(1,2,3,4,5,4,3,2,1)
    println("Con questi pilastri: ${pilastri.joinToString(" - ")}\n")
    //val volumeTotaleAcqua = calcolaAcquaForzaBruta(pilastri)
    //println("Il volume totale dell'acqua e': $volumeTotaleAcqua\n")
    val volumeTotaleAcqua = calcolaAcquaElegante(pilastri)
    println("Il volume totale dell'acqua e': $volumeTotaleAcqua\n")
}

/*fun calcolaAcquaForzaBruta(terreno: IntArray): Int {
    var total = 0
    for(pos in terreno.indices) {
        var maxDestra = 0
        var destra = pos
        while(destra < terreno.size) {
            maxDestra = max(maxDestra,terreno[destra])
            destra++
        }
        var maxSinistra = 0
        var sinistra = pos
        while(sinistra >= 0) {
            maxSinistra = max(maxSinistra,terreno[sinistra])
            sinistra--
        }
        if(min(maxSinistra,maxDestra) > 0 ) {
            total += (min(maxSinistra,maxDestra)-terreno[pos])
        }
    }
    return total
}*/

fun calcolaAcquaElegante(terreno: IntArray): Int {
    var totaleAcqua = 0
    var sinistra = 0
    var destra = terreno.size-1
    var massimoSinistra = 0
    var massimoDestra = 0
    while(sinistra<destra) {
        if(terreno[sinistra]<=terreno[destra]) {
            if(terreno[sinistra] < massimoSinistra) {
                totaleAcqua += massimoSinistra-terreno[sinistra]
                sinistra++
            } else {
                massimoSinistra = terreno[sinistra]
                sinistra++
            }
        } else {
            if(terreno[destra] < massimoDestra) {
                totaleAcqua += massimoDestra-terreno[destra]
                destra--
            } else {
                massimoDestra = terreno[destra]
                destra--
            }
        }
    }
    return totaleAcqua
}