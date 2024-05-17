package br.com.cantina.inteligente.cantinainteligente.services;

import br.com.cantina.inteligente.cantinainteligente.dto.DepositoDTO;
import br.com.cantina.inteligente.cantinainteligente.model.Cartao;
import br.com.cantina.inteligente.cantinainteligente.model.Deposito;
import br.com.cantina.inteligente.cantinainteligente.model.PaisDeAluno;
import br.com.cantina.inteligente.cantinainteligente.model.exceptions.ObjetoNaoEncontradoException;
import br.com.cantina.inteligente.cantinainteligente.repositories.CartaoRepository;
import br.com.cantina.inteligente.cantinainteligente.repositories.DepositoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DepositoService {

    private final DepositoRepository depositoRepository;
    private final CartaoRepository cartaoRepository;

    @Transactional
    public Deposito save(DepositoDTO depositoDTO) {
        Cartao cartao = cartaoRepository.findById(depositoDTO.getCartao().getId())
                .orElseThrow(() -> new IllegalArgumentException("Cartão não encontrado com o ID: " + depositoDTO.getCartao().getId()));

        double valorDeposito = depositoDTO.getValorDeposito();
        cartao.setSaldo(cartao.getSaldo() + valorDeposito);
        cartaoRepository.save(cartao);

        Deposito deposito = depositoRepository.save(new Deposito(
                depositoDTO.getCartao(),
                valorDeposito,
                depositoDTO.getDataDeposito()
        ));

        return depositoRepository.save(deposito);
    }

    public Deposito finById(Long id) {
        return depositoRepository.findById(id).orElseThrow(() -> new ObjetoNaoEncontradoException(" " + id + " Não foi encontrado na base de dados"));
    }

}
