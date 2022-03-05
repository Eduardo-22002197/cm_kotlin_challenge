package pt.ulusofona.cm.kotlin.challenge.exceptions

class PessoaSemCartaException (override val message: String = "No drivers license!"): Exception(message) {
}