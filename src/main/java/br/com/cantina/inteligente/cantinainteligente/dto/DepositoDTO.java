package br.com.cantina.inteligente.cantinainteligente.dto;

import br.com.cantina.inteligente.cantinainteligente.model.Cartao;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class DepositoDTO {
    private Cartao cartao;
    private Double valorDeposito;
    private LocalDate dataDeposito;
}
