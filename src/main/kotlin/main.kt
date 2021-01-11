import kotlin.math.max
import kotlin.math.min

fun main() {
    //val pilastri = intArrayOf(1,0,2,4,0,5,3,2,0,3) // 9
    //val pilastri = intArrayOf(1,0,2,4,0,5,3,2,0,4) // 12
    val pilastri = intArrayOf(3,0,2,4,0,5,3,2,0,4) // 15
    val volumeTotaleAcqua = calcolaAcquaForzaBruta(pilastri)
    println("Il volume totale dell'acqua e': $volumeTotaleAcqua")
}

fun calcolaAcquaForzaBruta(terreno: IntArray): Int {
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
        //total += (min(maxSinistra,maxDestra)-terreno[pos])
        if(min(maxSinistra,maxDestra) > 0 ) {
            total += (min(maxSinistra,maxDestra)-terreno[pos])
        }
    }
    return total
}