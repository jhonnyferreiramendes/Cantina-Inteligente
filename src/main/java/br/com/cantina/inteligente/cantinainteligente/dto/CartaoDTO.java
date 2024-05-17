package br.com.cantina.inteligente.cantinainteligente.dto;

import br.com.cantina.inteligente.cantinainteligente.model.Cartao;
import br.com.cantina.inteligente.cantinainteligente.model.Comprar;
import br.com.cantina.inteligente.cantinainteligente.model.PaisDeAluno;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class CartaoDTO {

    private String codigo;
    private String senha;
    private Double saldo;
    private Double limiteDiario;
    private Double limiteDiarioRedefinir;
    private PaisDeAluno paisDeAluno;

}
