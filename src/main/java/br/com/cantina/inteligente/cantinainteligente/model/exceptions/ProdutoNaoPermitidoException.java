package br.com.cantina.inteligente.cantinainteligente.model.exceptions;

public class ProdutoNaoPermitidoException extends RuntimeException {

    public ProdutoNaoPermitidoException(String message) {
        super(message);
    }
}
