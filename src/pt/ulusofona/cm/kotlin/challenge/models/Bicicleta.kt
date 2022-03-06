package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.AlterarPosicaoException
import pt.ulusofona.cm.kotlin.challenge.interfaces.Movimentavel

data class Bicicleta(var _identificador: String): Veiculo(_identificador), Movimentavel {
    override fun requerCarta(): Boolean {
        return false
    }

    override fun moverPara(x: Int, y: Int) {
        if(posicao.x != x && posicao.y != y) {
            posicao.x = x;
            posicao.y = y

        } else {
            throw AlterarPosicaoException()
        }
    }

    override fun toString(): String {
        return "Bicicleta | $_identificador | $dataDeAquisicao | $posicao | ${posicao.x} | ${posicao.y}"
    }
}
