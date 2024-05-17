package br.com.cantina.inteligente.cantinainteligente.services;


import br.com.cantina.inteligente.cantinainteligente.model.Cartao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LimiteDiarioService {

    private final CartaoService cartaoService;

    public LimiteDiarioService(CartaoService cartaoService) {
        this.cartaoService = cartaoService;
    }

    public Cartao getLimiteDiario(Long cartaoId) {
        Cartao limiteDiario = cartaoService.findById(cartaoId);
        return limiteDiario;
    }

    // Método agendado para ser executado às 10:30 da manhã todos os dias
    @Scheduled(cron = "0 30 8 * * *")
    public void resetarLimiteDiario() {
        List<Cartao> cartoes = cartaoService.findAll();


        for (Cartao cartao : cartoes) {
            cartao.setLimiteDiario(cartao.getLimiteDiarioRedefinir());
            cartaoService.update(cartao);
        }
    }
}
