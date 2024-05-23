package br.com.cantina.inteligente.cantinainteligente.dto;

import br.com.cantina.inteligente.cantinainteligente.model.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class ComprarDTO {


    private LocalDate data;
    private List<Produto> produtos;
    private Cartao cartao;
    private Cantina cantina;
    private Double valorTotal;
    private Long acessoCompraId;
    private PaisDeAluno paisDeAluno;
    private String senhaCartao;

}
