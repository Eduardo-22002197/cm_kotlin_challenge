package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.AlterarPosicaoException
import pt.ulusofona.cm.kotlin.challenge.interfaces.Movimentavel
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

open class Veiculo(open var identificador: String): Movimentavel {
    var posicao: Posicao = Posicao()
    val dateTime: LocalDateTime = LocalDateTime.now()
    var dataDeAquisicao: String = dateTime.format(DateTimeFormatter.ofPattern("M/d/y"))

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
