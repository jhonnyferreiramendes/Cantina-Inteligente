package br.com.cantina.inteligente.cantinainteligente.services;

import br.com.cantina.inteligente.cantinainteligente.dto.CartaoDTO;
import br.com.cantina.inteligente.cantinainteligente.dto.ProdutoDTO;
import br.com.cantina.inteligente.cantinainteligente.model.Cartao;
import br.com.cantina.inteligente.cantinainteligente.model.Produto;
import br.com.cantina.inteligente.cantinainteligente.model.exceptions.ObjetoNaoEncontradoException;
import br.com.cantina.inteligente.cantinainteligente.repositories.CartaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service

public class CartaoService {

    private final CartaoRepository cartaoRepository;

    public Cartao save(CartaoDTO cartaoDTO){
        var cartao = new Cartao(
                cartaoDTO.getCodigo(),
                cartaoDTO.getSenha(),
                cartaoDTO.getSaldo(),
                cartaoDTO.getLimiteDiario(),
                cartaoDTO.getLimiteDiarioRedefinir(),
                cartaoDTO.getPaisDeAluno()

        );
        cartao.setSaldo(0.0);
        cartao.setLimiteDiarioRedefinir(cartao.getLimiteDiario());
        return cartaoRepository.save(cartao);
    }

    public Cartao findById(Long id){
        return cartaoRepository.findById(id).orElseThrow(() -> new ObjetoNaoEncontradoException(" " + id + " Não foi encontrado na base de dados"));
    }
    public Optional<Cartao> findByCodigo(String codigo) {
        return cartaoRepository.findByCodigo(codigo);
    }

    public Cartao update (Cartao cartao){return cartaoRepository.save(cartao);}

    public void remover(Long id){
        Cartao cartao = cartaoRepository.findById(id).orElseThrow(() -> new ObjetoNaoEncontradoException("Cartao não encontrado"));
        cartaoRepository.delete(cartao);
    }

    public List<Cartao> findAll() {
        return cartaoRepository.findAll();
    }
}
