package pt.ulusofona.cm.kotlin.challenge.modules

import pt.ulusofona.cm.kotlin.challenge.exceptions.AlterarPosicaoException
import pt.ulusofona.cm.kotlin.challenge.interfaces.Movimentavel

class Bicicleta(private val identificador: String): Veiculo(identificador), Movimentavel {
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
        return "Bicicleta | $identificador | $dataDeAquisicao | $posicao | ${posicao.x} | ${posicao.y}"
    }
}
