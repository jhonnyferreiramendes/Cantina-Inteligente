package br.com.cantina.inteligente.cantinainteligente.services;

import br.com.cantina.inteligente.cantinainteligente.dto.AdministradorDTO;
import br.com.cantina.inteligente.cantinainteligente.model.Administrador;
import br.com.cantina.inteligente.cantinainteligente.model.exceptions.ObjetoNaoEncontradoException;
import br.com.cantina.inteligente.cantinainteligente.repositories.AdministradorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdministradorService {

    private final AdministradorRepository administradorRepository;

    public Administrador save(AdministradorDTO administradorDTO) {
        var administrador = new Administrador(
                administradorDTO.getNome(),
                administradorDTO.getCpf(),
                administradorDTO.getEndereco(),
                administradorDTO.getContato(),
                administradorDTO.getLogin(),
                administradorDTO.getCodigo());
        return administradorRepository.save(administrador);

    }

    public Administrador findByNome(String nome) {
        return administradorRepository.findByNome(nome).orElseThrow(() -> new ObjetoNaoEncontradoException(" " + nome + " Não foi encontrado na base de dados"));
    }

    public Administrador findByCodigo(String codigo) {
        return administradorRepository.findByCodigo(codigo).orElseThrow(() -> new ObjetoNaoEncontradoException(" " + codigo + " Não foi encontrado na base de dados"));
    }

    public Administrador update (Administrador administrador){return administradorRepository.save(administrador);}

    public void remover(Long id){
        Administrador administrador = administradorRepository.findById(id).orElseThrow(() -> new ObjetoNaoEncontradoException("Administrador não encontrado"));
        administradorRepository.delete(administrador);
    }
}
