package br.com.cantina.inteligente.cantinainteligente.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipo")
@Data
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @NotBlank
    @CPF
    private String cpf;

    @Embedded
    private Endereco endereco;

    @Embedded
    private Contato contato;

    @OneToOne(cascade = CascadeType.ALL)
    private Login login;

    public Usuario(String nome, String cpf, Endereco endereco, Contato contato, Login login) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.contato = contato;
        this.login = login;
    }
}
