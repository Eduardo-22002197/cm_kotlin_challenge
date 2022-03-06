package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.AlterarPosicaoException
import pt.ulusofona.cm.kotlin.challenge.interfaces.Movimentavel
import java.util.Date

data class Pessoa(var nome: String, var dataDeNascimento: Date): Movimentavel {
    // var veiculos: MutableList<Veiculo>()
    var posicao: Posicao = Posicao()
    var carta: Carta = Carta()

    override fun moverPara(x: Int, y: Int) {
        if(posicao.x != x && posicao.y != y) {
            posicao.x = x;
            posicao.y = y

        } else {
            throw AlterarPosicaoException()
        }
    }
}
