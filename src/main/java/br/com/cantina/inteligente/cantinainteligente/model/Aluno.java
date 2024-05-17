package br.com.cantina.inteligente.cantinainteligente.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@DiscriminatorValue("Aluno")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Aluno  extends Usuario{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnoreProperties(value = {"senha", "saldo", "saldo", "limiteDiario", "codigo"})
    @OneToOne
    @NotNull
    private Cartao cartao;

    public Aluno(String nome, String cpf, Endereco endereco, Contato contato, Login login, Cartao cartao) {
        super(nome, cpf, endereco, contato, login);
        this.cartao = cartao;
    }
}
