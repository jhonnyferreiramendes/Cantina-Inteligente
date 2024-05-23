package br.com.cantina.inteligente.cantinainteligente.services;

import br.com.cantina.inteligente.cantinainteligente.dto.ComprarDTO;
import br.com.cantina.inteligente.cantinainteligente.model.Cartao;
import br.com.cantina.inteligente.cantinainteligente.model.Comprar;
import br.com.cantina.inteligente.cantinainteligente.model.PaisDeAluno;
import br.com.cantina.inteligente.cantinainteligente.model.Produto;
import br.com.cantina.inteligente.cantinainteligente.model.exceptions.*;
import br.com.cantina.inteligente.cantinainteligente.repositories.CartaoRepository;
import br.com.cantina.inteligente.cantinainteligente.repositories.ComprarRepository;
import br.com.cantina.inteligente.cantinainteligente.repositories.PaisDeAlunoRepository;
import br.com.cantina.inteligente.cantinainteligente.repositories.ProdutoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ComprarService {

    private final ComprarRepository comprarRepository;
    private final ProdutoRepository produtoRepository;
    private final CartaoRepository cartaoRepository;
    private final PaisDeAlunoService paisDeAlunoService;

    private double calcularValorTotal(List<Produto> produtos) {
        double valorTotal = 0.0;
        for (Produto produto : produtos) {
            Produto produtoDoBanco = produtoRepository.findById(produto.getId())
                    .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado com o ID: " + produto.getId()));

            valorTotal += produtoDoBanco.getPreco();
        }
        return valorTotal;
    }

    private boolean produtosEstaoNaListaPermitida(PaisDeAluno paisDeAluno, List<Produto> produtos) {
        List<Produto> produtosPermitidos = paisDeAluno.getProdutosPermitidos();
        for (Produto produtoCompra : produtos) {
            boolean encontrado = false;
            for (Produto produtoPermitido : produtosPermitidos) {
                if (produtoCompra.getId().equals(produtoPermitido.getId())) {
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) {
                return false;
            }
        }
        return true;
    }

    @Transactional
    public Comprar save(ComprarDTO comprarDTO) {
        double valorTotal = calcularValorTotal(comprarDTO.getProdutos());
        Cartao cartao = cartaoRepository.findById(comprarDTO.getCartao().getId())
                .orElseThrow(() -> new IllegalArgumentException("Cartão não encontrado com o ID: " + comprarDTO.getCartao().getId()));
        if (!cartao.getPaisDeAluno().getId().equals(comprarDTO.getPaisDeAluno().getId())) {
            throw new IdIncorretoException("O ID do PaisDeAluno fornecido não corresponde ao ID vinculado ao cartão");
        }
        if (!cartao.getSenha().equals(comprarDTO.getSenhaCartao())) {
            throw new SenhaIncorretaException("Senha do cartão incorreta");
        }

        Double limiteDiario = cartao.getLimiteDiario();
        Double saldoCartao = cartao.getSaldo();

        if (saldoCartao < valorTotal) {
            throw new SaldoInsuficienteException("Saldo do cartão insuficiente");
        }

        if (valorTotal > limiteDiario) {
            throw new LimiteInsuficienteException("Limite diário do cartão insuficiente");
        }

        PaisDeAluno paisDeAluno = paisDeAlunoService.findById(comprarDTO.getPaisDeAluno().getId());

        if (!produtosEstaoNaListaPermitida(paisDeAluno, comprarDTO.getProdutos())) {
            throw new ProdutoNaoPermitidoException("Um ou mais produtos não são permitidos para compra");
        }

        double novoLimiteDiario = limiteDiario - valorTotal;
        double novoSaldo = saldoCartao - valorTotal;
        cartao.setLimiteDiario(novoLimiteDiario);
        cartao.setSaldo(novoSaldo);

        cartaoRepository.save(cartao);

        Comprar comprar = new Comprar(
                comprarDTO.getData(),
                comprarDTO.getProdutos(),
                comprarDTO.getCantina(),
                cartao,
                valorTotal,
                comprarDTO.getPaisDeAluno(),
                comprarDTO.getSenhaCartao()
        );

        return comprarRepository.save(comprar);
    }

    public Comprar findById(Long id){
        return comprarRepository.findById(id).orElseThrow(() -> new ObjetoNaoEncontradoException(" " + id + " Não foi encontrado na base de dados"));
    }

    public List<Comprar> findAll() {
        return comprarRepository.findAll();
    }

    public List<Comprar> findComprasByCantinaId(Long cantinaId) {
        return comprarRepository.findByCantinaId(cantinaId);
    }
}