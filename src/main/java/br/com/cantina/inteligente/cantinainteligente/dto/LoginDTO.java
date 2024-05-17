package br.com.cantina.inteligente.cantinainteligente.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class LoginDTO {

    private String email;
    private String senha;

}
