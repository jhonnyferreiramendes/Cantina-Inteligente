package br.com.cantina.inteligente.cantinainteligente.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Cartao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String codigo;

    @NotBlank
    private String senha;

    private Double saldo;

    private Double limiteDiario;

    @JsonIgnore
    private Double limiteDiarioRedefinir;

    @OneToOne
    @JsonIgnoreProperties(value = {"endereco" , "login", "contato", "cantina", "nome", "produtosPermitidos"})
    @NotNull
    private PaisDeAluno paisDeAluno;


    public Cartao(String codigo, String senha, Double saldo, Double limiteDiario, Double limiteDiarioRedefinir, PaisDeAluno paisDeAluno) {
        this.codigo = codigo;
        this.senha = senha;
        this.saldo = saldo;
        this.limiteDiario = limiteDiario;
        this.limiteDiarioRedefinir = limiteDiarioRedefinir;
        this.paisDeAluno = paisDeAluno;
    }
}
