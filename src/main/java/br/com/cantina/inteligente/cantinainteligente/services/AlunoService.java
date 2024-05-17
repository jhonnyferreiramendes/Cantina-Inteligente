package br.com.cantina.inteligente.cantinainteligente.services;

import br.com.cantina.inteligente.cantinainteligente.dto.AlunoDTO;
import br.com.cantina.inteligente.cantinainteligente.dto.PaisDeAlunoDTO;
import br.com.cantina.inteligente.cantinainteligente.model.Aluno;
import br.com.cantina.inteligente.cantinainteligente.model.Cantina;
import br.com.cantina.inteligente.cantinainteligente.model.PaisDeAluno;
import br.com.cantina.inteligente.cantinainteligente.model.exceptions.ObjetoNaoEncontradoException;
import br.com.cantina.inteligente.cantinainteligente.repositories.AlunoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class AlunoService {

    private final AlunoRepository alunoRepository;

    public Aluno save(AlunoDTO alunoDTO){
        var aluno= new Aluno(
                alunoDTO.getNome(),
                alunoDTO.getCpf(),
                alunoDTO.getEndereco(),
                alunoDTO.getContato(),
                alunoDTO.getLogin(),
                alunoDTO.getCartao()
                );
        return alunoRepository.save(aluno);
    }

    public Aluno finById(Long id) {
        return alunoRepository.findById(id).orElseThrow(() -> new ObjetoNaoEncontradoException(" " + id + " Não foi encontrado na base de dados"));
    }

    public Optional<List<Aluno>> findByNome(String nome) {
        return Optional.ofNullable(alunoRepository.findByNome(nome).orElseThrow(() -> new ObjetoNaoEncontradoException(" " + nome + " Não foi encontrado na base de dados")));
    }

    public Aluno update (Aluno aluno){return alunoRepository.save(aluno);}

    public void remover(Long id){
        Aluno aluno = alunoRepository.findById(id).orElseThrow(() -> new ObjetoNaoEncontradoException("Administrador não encontrado"));
        alunoRepository.delete(aluno);
    }

}
