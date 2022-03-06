package pt.ulusofona.cm.kotlin.challenge.exceptions

class PessoaSemCartaException (var name: String, override val message: String = "$name não tem carta para conduzir o veículo indicado"): Exception(message) {
}