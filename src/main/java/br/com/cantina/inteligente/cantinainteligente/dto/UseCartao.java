package br.com.cantina.inteligente.cantinainteligente.dto;

import br.com.cantina.inteligente.cantinainteligente.model.Cartao;
import lombok.Data;

@Data
public class UseCartao {

    private String codigo;
    private PaisDeAlunoDTO paisDeAluno;


}
