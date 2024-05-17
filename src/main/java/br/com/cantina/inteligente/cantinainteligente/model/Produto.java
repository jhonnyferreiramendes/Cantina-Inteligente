package br.com.cantina.inteligente.cantinainteligente.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @NotBlank
    @Column(unique = true)
    private String codigo;

    @NotBlank
    private String imagem;

    @NotNull
    private Double preco;

    @ManyToOne
    @JsonIgnoreProperties(value = {"endereco", "paisDeAluno", "contato", "produtos", "login", "cpf", "nome"})
    private Cantina cantina;

    public Produto(String nome, String codigo, String imagem, Double preco, Cantina cantina) {
        this.nome = nome;
        this.codigo = codigo;
        this.imagem = imagem;
        this.preco = preco;
        this.cantina = cantina;
    }


}
