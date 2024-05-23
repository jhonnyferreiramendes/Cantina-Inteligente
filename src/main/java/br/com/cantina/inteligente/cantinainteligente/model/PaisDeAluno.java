package br.com.cantina.inteligente.cantinainteligente.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@DiscriminatorValue("Pais de Alunos")
@Entity
@AllArgsConstructor
@NoArgsConstructor


public class PaisDeAluno extends Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cantina_id")
    @JsonIgnoreProperties(value = {"nome", "paisDeAluno", "produtos", "cpf", "endereco", "contato", "login"})
    private Cantina cantina;

    @ManyToMany
    @JsonIgnoreProperties(value = {"nome", "codigo", "imagem", "preco"})
    private List <Produto> produtosPermitidos;

    public PaisDeAluno(String nome, String cpf, Endereco endereco, Contato contato, Login login, Cantina cantina, List<Produto> produtosPermitidos) {
        super(nome, cpf, endereco, contato, login);
        this.cantina = cantina;
        this.produtosPermitidos = produtosPermitidos;
    }

}
