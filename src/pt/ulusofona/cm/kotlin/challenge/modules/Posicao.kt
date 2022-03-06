package pt.ulusofona.cm.kotlin.challenge.modules

class Posicao(var x: Int = 0, var y: Int = 0) {
    fun alteraPosicaoPara(x: Int, y: Int) {
        this.x = x
        this.y = y
    }

    override fun toString(): String {
        return "Posicao | x:${this.x} | y:${this.y}"
    }
}
