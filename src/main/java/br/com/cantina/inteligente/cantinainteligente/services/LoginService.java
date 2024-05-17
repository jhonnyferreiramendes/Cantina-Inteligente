package br.com.cantina.inteligente.cantinainteligente.services;


import br.com.cantina.inteligente.cantinainteligente.dto.LoginDTO;
import br.com.cantina.inteligente.cantinainteligente.model.Cartao;
import br.com.cantina.inteligente.cantinainteligente.model.Comprar;
import br.com.cantina.inteligente.cantinainteligente.model.Login;
import br.com.cantina.inteligente.cantinainteligente.model.exceptions.ObjetoNaoEncontradoException;
import br.com.cantina.inteligente.cantinainteligente.repositories.LoginRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class LoginService {

    private final LoginRepository loginRepository;

    public Login findById(Long id){
        return loginRepository.findById(id).orElseThrow(() -> new ObjetoNaoEncontradoException(" " + id + " Não foi encontrado na base de dados"));
    }

    public List<Login> findAll() {
        return loginRepository.findAll();
    }

    public Login update (Login login){return loginRepository.save(login);}


}
