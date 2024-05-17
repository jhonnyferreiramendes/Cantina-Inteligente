package br.com.cantina.inteligente.cantinainteligente.controller;

import br.com.cantina.inteligente.cantinainteligente.model.Cartao;
import br.com.cantina.inteligente.cantinainteligente.services.LimiteDiarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class LimiteDiarioController {

    private final LimiteDiarioService limiteDiarioService;

    @Autowired
    public LimiteDiarioController(LimiteDiarioService limiteDiarioService) {
        this.limiteDiarioService = limiteDiarioService;
    }

    @GetMapping("/limiteDiario/{cartaoId}")
    public Cartao getLimiteDiario(@PathVariable Long cartaoId) {
        return limiteDiarioService.getLimiteDiario(cartaoId);
    }
}
