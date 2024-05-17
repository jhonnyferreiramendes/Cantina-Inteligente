package br.com.cantina.inteligente.cantinainteligente.dto;

import br.com.cantina.inteligente.cantinainteligente.model.*;
import lombok.Data;

import java.util.List;

@Data

public class PaisDeAlunoDTO {
    private String nome;
    private String cpf;
    private Endereco endereco;
    private Contato contato;
    private Login login;
    private Cantina cantina;
    private List<Produto> produtosPermitidos;
}
