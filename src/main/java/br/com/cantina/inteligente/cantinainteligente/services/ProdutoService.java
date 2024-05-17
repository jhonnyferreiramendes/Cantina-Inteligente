package br.com.cantina.inteligente.cantinainteligente.services;

import br.com.cantina.inteligente.cantinainteligente.dto.ProdutoDTO;
import br.com.cantina.inteligente.cantinainteligente.model.PaisDeAluno;
import br.com.cantina.inteligente.cantinainteligente.model.Produto;
import br.com.cantina.inteligente.cantinainteligente.model.exceptions.ObjetoNaoEncontradoException;
import br.com.cantina.inteligente.cantinainteligente.repositories.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public Produto save(ProdutoDTO produtoDTO){
        var produto = new Produto(
                produtoDTO.getNome(),
                produtoDTO.getCodigo(),
                produtoDTO.getImagem(),
                produtoDTO.getPreco(),
                produtoDTO.getCantina()
        );
        return produtoRepository.save(produto);
    }

    public Produto findById(Long id){
        return produtoRepository.findById(id).orElseThrow(() -> new ObjetoNaoEncontradoException(" " + id + " Não foi encontrado na base de dados"));
    }
    public Optional<List<Produto>> findByNome(String nome) {
        return produtoRepository.findByNome(nome);
    }

    public Produto update (Produto produto){return produtoRepository.save(produto);}

    public void remover(Long id){
        Produto produto = produtoRepository.findById(id).orElseThrow(() -> new ObjetoNaoEncontradoException("Administrador não encontrado"));
        produtoRepository.delete(produto);
    }

}
