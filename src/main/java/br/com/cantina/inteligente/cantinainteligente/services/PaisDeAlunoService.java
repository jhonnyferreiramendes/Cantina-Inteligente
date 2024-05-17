package br.com.cantina.inteligente.cantinainteligente.services;

import br.com.cantina.inteligente.cantinainteligente.dto.PaisDeAlunoDTO;
import br.com.cantina.inteligente.cantinainteligente.model.PaisDeAluno;
import br.com.cantina.inteligente.cantinainteligente.model.Produto;
import br.com.cantina.inteligente.cantinainteligente.model.exceptions.ObjetoNaoEncontradoException;
import br.com.cantina.inteligente.cantinainteligente.repositories.PaisDeAlunoRepository;
import br.com.cantina.inteligente.cantinainteligente.repositories.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PaisDeAlunoService {

    private final PaisDeAlunoRepository paisDeAlunoRepository;
    private final ProdutoRepository produtoRepository;

    public PaisDeAluno save(PaisDeAlunoDTO paisDeAlunoDTO){
        var paisDeAluno= new PaisDeAluno(
                paisDeAlunoDTO.getNome(),
                paisDeAlunoDTO.getCpf(),
                paisDeAlunoDTO.getEndereco(),
                paisDeAlunoDTO.getContato(),
                paisDeAlunoDTO.getLogin(),
                paisDeAlunoDTO.getCantina(),
                paisDeAlunoDTO.getProdutosPermitidos());
        return paisDeAlunoRepository.save(paisDeAluno);
    }

    public PaisDeAluno findById(Long id) {
        return paisDeAlunoRepository.findById(id).orElseThrow(() -> new ObjetoNaoEncontradoException(" " + id + " Não foi encontrado na base de dados"));
    }

    public Optional<List<PaisDeAluno>> findByNome(String nome) {
        return Optional.ofNullable(paisDeAlunoRepository.findByNome(nome).orElseThrow(() -> new ObjetoNaoEncontradoException(" " + nome + " Não foi encontrado na base de dados")));
    }

    public PaisDeAluno update (PaisDeAluno paisDeAluno){return paisDeAlunoRepository.save(paisDeAluno);}

    public void remover(Long id){
        PaisDeAluno paisDeAluno = paisDeAlunoRepository.findById(id).orElseThrow(() -> new ObjetoNaoEncontradoException("Administrador não encontrado"));
        paisDeAlunoRepository.delete(paisDeAluno);
    }

    public void adicionarProduto(Long paisDeAlunoId, Long produtoId) {
        PaisDeAluno paisDeAluno = paisDeAlunoRepository.findById(paisDeAlunoId)
                .orElseThrow(() -> new ObjetoNaoEncontradoException("PaisDeAluno com ID " + paisDeAlunoId + " não encontrado"));

        Produto produto = produtoRepository.findById(produtoId)
                .orElseThrow(() -> new ObjetoNaoEncontradoException("Produto com ID " + produtoId + " não encontrado"));

        paisDeAluno.getProdutosPermitidos().add(produto);
        paisDeAlunoRepository.save(paisDeAluno);
    }

    public void removerProduto(Long paisDeAlunoId, Long produtoId) {
        PaisDeAluno paisDeAluno = paisDeAlunoRepository.findById(paisDeAlunoId)
                .orElseThrow(() -> new ObjetoNaoEncontradoException("PaisDeAluno com ID " + paisDeAlunoId + " não encontrado"));

        Produto produto = produtoRepository.findById(produtoId)
                .orElseThrow(() -> new ObjetoNaoEncontradoException("Produto com ID " + produtoId + " não encontrado"));

        paisDeAluno.getProdutosPermitidos().remove(produto);
        paisDeAlunoRepository.save(paisDeAluno);
    }

}

