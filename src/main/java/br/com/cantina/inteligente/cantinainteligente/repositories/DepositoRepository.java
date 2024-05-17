package br.com.cantina.inteligente.cantinainteligente.repositories;

import br.com.cantina.inteligente.cantinainteligente.model.Deposito;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DepositoRepository extends JpaRepository<Deposito, Long> {

    Optional <Deposito> findById(Long id);
}
