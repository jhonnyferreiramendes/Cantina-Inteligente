package br.com.cantina.inteligente.cantinainteligente.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Comprar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private LocalDate data;

    @ManyToMany
    @JsonIgnoreProperties(value = {"cantina"})
    private List<Produto> produtos;

    @ManyToOne
    @JsonIgnoreProperties(value = {"endereco", "paisDeAluno", "contato", "produtos", "login", "cpf", "nome"})
    private Cantina cantina;

    @ManyToOne
    @JsonIgnoreProperties(value = {"senha", "saldo", "limiteDiario", "codigo", "limiteDiarioRedefinir", "preco", "paisDeAluno"})
    private Cartao cartao;

    private Double valorTotal;

    @ManyToOne
    @JoinColumn(name = "pais_de_aluno_id")
    @JsonIgnoreProperties(value = {"endereco" , "login", "contato", "cantina", "nome", "produtosPermitidos"})
    private PaisDeAluno paisDeAluno;

    @NotBlank
    private String senhaCartao;

    public Comprar(LocalDate data, List<Produto> produtos, Cantina cantina, Cartao cartao, Double valorTotal, PaisDeAluno paisDeAluno, String senhaCartao) {
        this.data = data;
        this.produtos = produtos;
        this.cantina = cantina;
        this.cartao = cartao;
        this.valorTotal = valorTotal;
        this.paisDeAluno = paisDeAluno;
        this.senhaCartao = senhaCartao;
    }
}

