package br.com.cantina.inteligente.cantinainteligente.dto;

import br.com.cantina.inteligente.cantinainteligente.model.Cantina;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data

public class ProdutoDTO {
    private String nome;
    private String codigo;
    private String imagem;
    private Double preco;
    private Cantina cantina;


}
