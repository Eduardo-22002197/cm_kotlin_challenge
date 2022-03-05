package pt.ulusofona.cm.kotlin.challenge.exceptions

class VeiculoDesligadoException (override val message: String = "Vehicle turned off!"): Exception(message) {
}