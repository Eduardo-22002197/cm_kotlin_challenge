package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.AlterarPosicaoException
import pt.ulusofona.cm.kotlin.challenge.exceptions.MenorDeIdadeException
import pt.ulusofona.cm.kotlin.challenge.exceptions.PessoaSemCartaException
import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoNaoEncontradoException
import pt.ulusofona.cm.kotlin.challenge.interfaces.Ligavel
import pt.ulusofona.cm.kotlin.challenge.interfaces.Movimentavel
import java.util.Date
import java.text.SimpleDateFormat;

data class Pessoa(var nome: String, var dataDeNascimento: Date): Movimentavel {
    var DateFor: SimpleDateFormat = SimpleDateFormat("dd-MM-yyyy")
    var stringDate: String = DateFor.format(dataDeNascimento)
    var veiculos = mutableListOf<Veiculo>()
    var posicao: Posicao = Posicao()
    var carta: Carta? = null

    fun comprarVeiculo(veiculo: Veiculo) {
        var dataAquisicaoNew = DateFor.format(Date())
        veiculo.dataDeAquisicao = dataAquisicaoNew
        veiculos.add(veiculo)
    }

    fun pesquisarVeiculo(identificador: String): Veiculo {
        for(tempVeiculo in veiculos) {
            if (tempVeiculo.identificador == identificador) {
                return tempVeiculo
            }
        }

        return throw VeiculoNaoEncontradoException()
    }

    fun venderVeiculo(identificador: String, comprador: Pessoa) {
        var dataVenda = DateFor.format(Date())

        for(tempVeiculo in veiculos) {
            if(tempVeiculo.identificador == identificador) {
                tempVeiculo.dataDeAquisicao = dataVenda
                comprador.veiculos.add(tempVeiculo)
                veiculos.remove(tempVeiculo)
            }
        }
    }

    fun moverVeiculoPara(identificador: String, x: Int, y: Int) {
        for(tempVeiculo in veiculos) {
            if (tempVeiculo.identificador == identificador) {
                if(temCarta() && tempVeiculo is Ligavel) {
                    if (tempVeiculo.posicao.x != x && tempVeiculo.posicao.y != y) {
                        tempVeiculo.posicao.alteraPosicaoPara(x, y)

                    } else {
                        throw AlterarPosicaoException()
                    }

                } else {
                    throw PessoaSemCartaException(nome)
                }
            }
        }
    }

    fun temCarta(): Boolean {
        if(carta != null) {
            return true
        }

        return false
    }

    fun tirarCarta() {
        val todayYear: Int = Date().year + 1900
        if (todayYear - dataDeNascimento.year + 1900 >= 18) {
            carta = Carta()

        } else {
            throw MenorDeIdadeException()
        }
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
        return "Pessoa | $nome | $stringDate | $posicao"
    }
}
