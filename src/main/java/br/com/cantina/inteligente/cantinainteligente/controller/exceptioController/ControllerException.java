package br.com.cantina.inteligente.cantinainteligente.controller.exceptioController;

import br.com.cantina.inteligente.cantinainteligente.exception.PadraoException;
import br.com.cantina.inteligente.cantinainteligente.model.exceptions.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDate;

@ControllerAdvice
public class ControllerException {

    @ExceptionHandler(ObjetoNaoEncontradoException.class)
    public ResponseEntity<PadraoException> objetoNaoEncontradoException(
            ObjetoNaoEncontradoException ex, HttpServletRequest request
    ) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(PadraoException.builder()
                        .erro("Objeto nao encontrado!")
                        .message(ex.getMessage())
                        .path(request.getRequestURI())
                        .status(HttpStatus.NO_CONTENT.value())
                        .timetamp(LocalDate.now())
                        .build());


    }

    @ExceptionHandler(LimiteInsuficienteException.class)
    public ResponseEntity<PadraoException> limiteInsuficiente(LimiteInsuficienteException ex, HttpServletRequest request) {
        PadraoException response = PadraoException.builder()
                .timetamp(LocalDate.now())
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .erro("Internal Server Error")
                .message("Limite diário do cartão insuficiente")
                .build();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

    @ExceptionHandler(SaldoInsuficienteException.class)
    public ResponseEntity<PadraoException> saldoInsuficiente(SaldoInsuficienteException ex, HttpServletRequest request) {
        PadraoException response = PadraoException.builder()
                .timetamp(LocalDate.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .erro("Saldo do cartão insuficiente")
                .message(ex.getMessage())
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(ProdutoNaoPermitidoException.class)
    public ResponseEntity<PadraoException> produtoNaoPermitido(ProdutoNaoPermitidoException ex, HttpServletRequest request) {
        PadraoException response = PadraoException.builder()
                .timetamp(LocalDate.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .erro("Produto nao permitido")
                .message(ex.getMessage())
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(IdIncorretoException.class)
    public ResponseEntity<PadraoException> idIncorreto(IdIncorretoException ex, HttpServletRequest request) {
        PadraoException response = PadraoException.builder()
                .timetamp(LocalDate.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .erro("ID incorreto")
                .message(ex.getMessage())
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(SenhaIncorretaException.class)
    public ResponseEntity<PadraoException> idIncorreto(SenhaIncorretaException ex, HttpServletRequest request) {
        PadraoException response = PadraoException.builder()
                .timetamp(LocalDate.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .erro("Senha incorreta")
                .message(ex.getMessage())
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}
