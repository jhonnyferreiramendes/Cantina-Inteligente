package br.com.cantina.inteligente.cantinainteligente.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Deposito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonIgnoreProperties(value = {"senha", "saldo", "saldo", "limiteDiario", "codigo"})
    private Cartao cartao;

    @NotNull
    private Double valorDeposito;

    @NotNull
    private LocalDate dataDeposito;

    public Deposito(Cartao cartao, Double valorDeposito, LocalDate dataDeposito) {
        this.cartao = cartao;
        this.valorDeposito = valorDeposito;
        this.dataDeposito = dataDeposito;
    }
}
