package br.com.cantina.inteligente.cantinainteligente.model;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Contato {

    private String enderecoEmail;
    private String celular;

}
