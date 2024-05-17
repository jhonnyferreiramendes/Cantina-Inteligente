package br.com.cantina.inteligente.cantinainteligente.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@DiscriminatorValue("Cantina")
@Entity
@AllArgsConstructor
@NoArgsConstructor


public class Cantina extends Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cantina")
    private List <PaisDeAluno> paisDeAluno;

    @OneToMany(mappedBy = "cantina", cascade = CascadeType.ALL)
    private List<Produto> produtos;

    

    public Cantina(String nome, String cpf, Endereco endereco, Contato contato, Login login, List<PaisDeAluno> paisDeAluno, List<Produto> produtos) {
        super(nome, cpf, endereco, contato, login);
        this.paisDeAluno = paisDeAluno;
        this.produtos = produtos;
    }
}

