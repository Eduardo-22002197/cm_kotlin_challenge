package pt.ulusofona.cm.kotlin.challenge.modules

import pt.ulusofona.cm.kotlin.challenge.exceptions.AlterarPosicaoException
import pt.ulusofona.cm.kotlin.challenge.interfaces.Movimentavel
import java.util.Date

open class Veiculo(private var identificador: String): Movimentavel {
    var posicao: Posicao = Posicao()
    var dataDeAquisicao: Date = Date()

    open fun requerCarta(): Boolean {
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
        return "Veiculo | $identificador"
    }
}
