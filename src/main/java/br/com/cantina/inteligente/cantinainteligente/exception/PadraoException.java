package br.com.cantina.inteligente.cantinainteligente.exception;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Builder
@Data
public class PadraoException {

    private LocalDate timetamp;
    private Integer status;
    private String erro;
    private String message;
    private String path;
}
