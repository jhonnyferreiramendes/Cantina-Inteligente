package br.com.cantina.inteligente.cantinainteligente.dto;

import br.com.cantina.inteligente.cantinainteligente.model.*;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

@Data
public class AlunoDTO {

    private String nome;
    private String cpf;
    private Cartao cartao;
    private Contato contato;
    private Endereco endereco;
    private Login login;


}
