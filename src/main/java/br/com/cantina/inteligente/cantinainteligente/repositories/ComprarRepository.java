package br.com.cantina.inteligente.cantinainteligente.repositories;

import br.com.cantina.inteligente.cantinainteligente.model.Comprar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ComprarRepository extends JpaRepository <Comprar, Long> {

    Optional<Comprar> findById(Long id);
    List<Comprar> findAll();
    List<Comprar> findByCantinaId(Long cantinaId);
}
