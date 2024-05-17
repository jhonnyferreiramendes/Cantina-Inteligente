package br.com.cantina.inteligente.cantinainteligente.dto;

import br.com.cantina.inteligente.cantinainteligente.model.*;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

import java.util.List;
@Data
public class CantinaDTO {

    private String nome;
    private String cpf;
    private Endereco endereco;
    private Contato contato;
    private Login login;
    private List <PaisDeAluno> paisDeAluno;
    private List <Produto> produtos;
}
