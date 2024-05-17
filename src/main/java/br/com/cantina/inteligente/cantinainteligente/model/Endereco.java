package br.com.cantina.inteligente.cantinainteligente.model;


import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Endereco {

    private String UF;
    private String cidade;
    private String bairro;
    private String rua;
    private String numero;
    private String cep;

}
