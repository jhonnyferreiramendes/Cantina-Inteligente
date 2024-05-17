package br.com.cantina.inteligente.cantinainteligente.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@DiscriminatorValue("ADM")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Administrador extends Usuario{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(unique = true)
    private String codigo;

    public Administrador(String nome, String cpf, Endereco endereco, Contato contato, Login login, String codigo) {
        super(nome, cpf, endereco, contato, login);
        this.codigo = codigo;
    }


}
