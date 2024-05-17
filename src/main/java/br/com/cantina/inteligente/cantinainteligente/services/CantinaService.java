package br.com.cantina.inteligente.cantinainteligente.services;


import br.com.cantina.inteligente.cantinainteligente.dto.CantinaDTO;
import br.com.cantina.inteligente.cantinainteligente.model.Administrador;
import br.com.cantina.inteligente.cantinainteligente.model.Cantina;
import br.com.cantina.inteligente.cantinainteligente.model.exceptions.ObjetoNaoEncontradoException;
import br.com.cantina.inteligente.cantinainteligente.repositories.CantinaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CantinaService {

    private final CantinaRepository cantinaRepository;

    public Cantina save(CantinaDTO cantinaDTO){
        var cantina = new Cantina(
              cantinaDTO.getNome(),
              cantinaDTO.getCpf(),
              cantinaDTO.getEndereco(),
              cantinaDTO.getContato(),
              cantinaDTO.getLogin(),
              cantinaDTO.getPaisDeAluno(),
              cantinaDTO.getProdutos()
                );
        return cantinaRepository.save(cantina);
    }

    public Cantina finById(Long id) {
        return cantinaRepository.findById(id).orElseThrow(() -> new ObjetoNaoEncontradoException(" " + id + " Não foi encontrado na base de dados"));
    }

    public Optional <List<Cantina>> findByNome(String nome) {
        return Optional.ofNullable(cantinaRepository.findByNome(nome).orElseThrow(() -> new ObjetoNaoEncontradoException(" " + nome + " Não foi encontrado na base de dados")));
    }

    public Cantina update (Cantina cantina){return cantinaRepository.save(cantina);}

    public void remover(Long id){
        Cantina cantina = cantinaRepository.findById(id).orElseThrow(() -> new ObjetoNaoEncontradoException("Administrador não encontrado"));
        cantinaRepository.delete(cantina);
    }


}
