package br.com.cantina.inteligente.cantinainteligente.dto;

import br.com.cantina.inteligente.cantinainteligente.model.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import java.util.List;
@Data
public class AdministradorDTO {

    private String nome;
    private String cpf;
    private Endereco endereco;
    private Contato contato;
    private Login login;
    private String codigo;

}
