package br.com.cantina.inteligente.cantinainteligente.config;

import br.com.cantina.inteligente.cantinainteligente.services.LimiteDiarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class ConfiguracaoAgendador {

    @Autowired
    private LimiteDiarioService servicoLimiteDiario;

    @Scheduled(cron = "0 0 7 * * *")
    public void resetarLimiteDiario() {
        servicoLimiteDiario.resetarLimiteDiario();
    }
}
