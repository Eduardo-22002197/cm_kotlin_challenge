package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.AlterarPosicaoException
import pt.ulusofona.cm.kotlin.challenge.interfaces.Movimentavel
import java.text.SimpleDateFormat
import java.util.Date

open class Veiculo(open var identificador: String): Movimentavel {
    var posicao: Posicao = Posicao()
    val dateTime: Date = Date()
    var DateFor: SimpleDateFormat = SimpleDateFormat("dd/MM/yyyy")
    var dataDeAquisicao: String = DateFor.format(dateTime)

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
