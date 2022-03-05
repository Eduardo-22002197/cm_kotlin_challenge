package pt.ulusofona.cm.kotlin.challenge.exceptions;

public class VeiculoNaoEncontradoException (override val message: String = "Vehicle not found!"): Exception(message) {
}
