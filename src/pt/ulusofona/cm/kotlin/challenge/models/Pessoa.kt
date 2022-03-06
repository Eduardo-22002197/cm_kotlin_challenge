package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.AlterarPosicaoException
import pt.ulusofona.cm.kotlin.challenge.interfaces.Movimentavel
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class Pessoa(var nome: String, var dataDeNascimento: String = LocalDateTime.now().format(DateTimeFormatter.ofPattern("M/d/y"))): Movimentavel {
    var veiculos = listOf<Veiculo>()
    var posicao: Posicao = Posicao()
    var carta: Carta? = null

    fun comprarVeiculo(veiculo: Veiculo) {

    }

    fun pesquisarVeiculo(identificador: String): Veiculo? {
        return null;
    }

    fun venderVeiculo(identificador: String, comprador: Pessoa) {

    }

    fun moverVeiculoPara(identificador: String, x: Int, y: Int) {

    }

    fun temCarta(): Boolean {
        if(carta != null) {
            return true
        }

        return false
    }

    fun tirarCarta() {

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
        return "Pessoa | $nome | $dataDeNascimento | $posicao"
    }
}
