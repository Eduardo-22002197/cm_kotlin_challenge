package pt.ulusofona.cm.kotlin.challenge.modules

import pt.ulusofona.cm.kotlin.challenge.exceptions.AlterarPosicaoException
import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoDesligadoException
import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoLigadoException
import pt.ulusofona.cm.kotlin.challenge.interfaces.Ligavel
import pt.ulusofona.cm.kotlin.challenge.interfaces.Movimentavel

class Carro(private var identificador: String): Veiculo(identificador), Movimentavel, Ligavel {
    var motor: Motor = Motor()

    override fun requerCarta(): Boolean {
        return true
    }

    override fun ligar() {
        if(motor.estaLigado()) {
            throw VeiculoLigadoException()

        } else {
            motor.ligado = true
        }
    }

    override fun desligar() {
        if(!motor.estaLigado()) {
            throw VeiculoDesligadoException()

        } else {
            motor.ligado = false
        }
    }

    override fun estaLigado(): Boolean {
        return motor.estaLigado()
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
        return "Carro | $identificador | $dataDeAquisicao | $posicao | ${posicao.x} | ${posicao.y}"
    }
}
