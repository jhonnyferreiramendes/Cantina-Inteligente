package br.com.cantina.inteligente.cantinainteligente.model.exceptions;

public class SaldoInsuficienteException extends RuntimeException{

    public SaldoInsuficienteException(String msg) {
        super(msg);
    }
}
